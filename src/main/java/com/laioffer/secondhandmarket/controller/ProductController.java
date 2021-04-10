package com.laioffer.secondhandmarket.controller;

import com.laioffer.secondhandmarket.entity.Customer;
import com.laioffer.secondhandmarket.payload.request.AddProductRequest;
import com.laioffer.secondhandmarket.payload.response.MessageResponse;
import com.laioffer.secondhandmarket.service.CustomerService;
import com.laioffer.secondhandmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody AddProductRequest addProductRequest) {
        try {
            productService.addProduct(addProductRequest);
            return ResponseEntity.ok(new MessageResponse("Product Added successfully!"));
        } catch (RuntimeException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
