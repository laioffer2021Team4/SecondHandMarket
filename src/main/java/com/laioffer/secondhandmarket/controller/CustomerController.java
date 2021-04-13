package com.laioffer.secondhandmarket.controller;


import com.laioffer.secondhandmarket.entity.Customer;
import com.laioffer.secondhandmarket.payload.request.ProfileRequest;
import com.laioffer.secondhandmarket.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@Valid @RequestBody ProfileRequest profileRequest) {
        try {
            Customer customer = customerService.getCustomerByEmail(profileRequest.getEmail());
            return ResponseEntity.ok(customer);
        } catch (RuntimeException e) {
            logger.error("Failed to get Profile: " + e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
