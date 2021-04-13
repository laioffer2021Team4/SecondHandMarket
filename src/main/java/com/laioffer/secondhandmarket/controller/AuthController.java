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
import com.laioffer.secondhandmarket.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger( AuthController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            JsonWebTokenResponse jsonWebTokenResponse =
                    authService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

            return ResponseEntity.ok(jsonWebTokenResponse);

        } catch (RuntimeException e) {
            logger.error("Can not authenticate user: " + e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        try {
            authService.registerUser(signUpRequest);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } catch (RuntimeException e) {
            logger.error("Failed to create customer: " + e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/logout")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LogoutRequest logoutRequest) {
        JasonWebTokenUtils.invalidateRelatedTokens(logoutRequest);
        return ResponseEntity.ok(new MessageResponse("User Logged out successfully!"));
    }
}
