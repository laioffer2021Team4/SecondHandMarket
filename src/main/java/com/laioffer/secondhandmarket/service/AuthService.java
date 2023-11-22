package com.laioffer.secondhandmarket.service;

import com.laioffer.secondhandmarket.entity.Role;
import com.laioffer.secondhandmarket.entity.User;
import com.laioffer.secondhandmarket.entity.UserRole;
import com.laioffer.secondhandmarket.payload.request.SignupRequest;
import com.laioffer.secondhandmarket.payload.response.JsonWebTokenResponse;
import com.laioffer.secondhandmarket.repository.RoleRepository;
import com.laioffer.secondhandmarket.security.jsonwebtoken.JasonWebTokenUtils;
import com.laioffer.secondhandmarket.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Component
public class AuthService {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JasonWebTokenUtils jwtUtils;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  CustomerService customerService;


  public JsonWebTokenResponse authenticateUser(String username, String password) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(username, password));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication, username);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList());

    return new JsonWebTokenResponse(jwt, userDetails.getId(), userDetails.getEmail(), roles,
        customerService.getCustomerByEmail(username));
  }

  public void registerUser(SignupRequest signupRequest) {

    // Create new user's account
    User user = User.builder()
        .email(signupRequest.getEmail())
        .password(encoder.encode(signupRequest.getPassword()))
        .build();

    Set<String> strRoles = signupRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        if ("admin".equals(role)) {
          Role adminRole = roleRepository.findByName(UserRole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);
        } else {
          Role userRole = roleRepository.findByName(UserRole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    customerService.createCustomer(signupRequest, user);

  }
}
