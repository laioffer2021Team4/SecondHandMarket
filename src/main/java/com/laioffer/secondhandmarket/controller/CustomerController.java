package com.laioffer.secondhandmarket.controller;


import com.laioffer.secondhandmarket.entity.Customer;
import com.laioffer.secondhandmarket.entity.User;
import com.laioffer.secondhandmarket.payload.request.LoginRequest;
import com.laioffer.secondhandmarket.payload.request.ProfileRequest;
import com.laioffer.secondhandmarket.payload.response.JsonWebTokenResponse;
import com.laioffer.secondhandmarket.repository.CustomerRepository;
import com.laioffer.secondhandmarket.repository.UserRepository;
import com.laioffer.secondhandmarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.cmm.Profile;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@Valid @RequestBody ProfileRequest profileRequest) {

        Customer customer = customerService.getCustomer(profileRequest.getEmail());
        return ResponseEntity.ok(customer);

    }
}
