package com.laioffer.secondhandmarket.controller;

import javax.validation.Valid;

import com.laioffer.secondhandmarket.payload.request.LoginRequest;
import com.laioffer.secondhandmarket.payload.request.LogoutRequest;
import com.laioffer.secondhandmarket.payload.request.SignupRequest;
import com.laioffer.secondhandmarket.payload.response.JsonWebTokenResponse;
import com.laioffer.secondhandmarket.payload.response.MessageResponse;
import com.laioffer.secondhandmarket.repository.UserRepository;
import com.laioffer.secondhandmarket.security.jsonwebtoken.JasonWebTokenUtils;
import com.laioffer.secondhandmarket.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JasonWebTokenUtils jwtUtils;

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JsonWebTokenResponse jsonWebTokenResponse =
                authService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

        return ResponseEntity.ok(jsonWebTokenResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        authService.registerUser(signUpRequest);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


    @PostMapping("/logout")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LogoutRequest logoutRequest) {
        JasonWebTokenUtils.invalidateRelatedTokens(logoutRequest);
        return ResponseEntity.ok(new MessageResponse("User Logged out successfully!"));
    }
}
