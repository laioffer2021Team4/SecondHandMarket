package com.laioffer.secondhandmarket.controller;

import com.laioffer.secondhandmarket.entity.Product;
import com.laioffer.secondhandmarket.payload.request.AddProductRequest;
import com.laioffer.secondhandmarket.payload.response.MessageResponse;
import com.laioffer.secondhandmarket.payload.response.ProductResponse;
import com.laioffer.secondhandmarket.service.CustomerService;
import com.laioffer.secondhandmarket.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody AddProductRequest addProductRequest) {
        try {
            productService.addProduct(addProductRequest);
            return ResponseEntity.ok(new MessageResponse("Product Added successfully!"));
        } catch (RuntimeException e) {
            logger.error("Failed to add new product " + e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }

    @GetMapping("/products/{email}")
    public ResponseEntity<List<ProductResponse>> listAllProductsByEmail(@PathVariable String email) {
            try {
                List<ProductResponse> products = productService.listAllProductsByEmail(email);
                if (products.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }
                return new ResponseEntity<>(products, HttpStatus.OK);
            } catch (RuntimeException e) {
                logger.error("Failed to list products :" + e);
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        try {
            Product product = productService.getProductById((Integer.parseInt(id)));
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NumberFormatException ex) {
            logger.error("Error number Id format");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            logger.error("Failed to get product :" + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<ProductResponse>> searchProductByKeyword(@PathVariable String keyword) {
        try {
            List<ProductResponse> products = productService.getProductByKeyword(keyword);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
