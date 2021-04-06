package com.laioffer.secondhandmarket.controller;


import com.laioffer.secondhandmarket.repository.CustomerRepository;
import com.laioffer.secondhandmarket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CustomerRepository customerRepository;


}
