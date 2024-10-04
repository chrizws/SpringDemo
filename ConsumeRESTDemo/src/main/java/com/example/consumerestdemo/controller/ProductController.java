package com.example.consumerestdemo.controller;

import com.example.consumerestdemo.model.Payment;
import com.example.consumerestdemo.model.Product;
import com.example.consumerestdemo.proxy.ProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    private final ProductProxy productProxy;

    @Autowired
    public ProductController(ProductProxy productProxy) {
        this.productProxy = productProxy;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestHeader (required = false) String id, @RequestBody Product product) {
        product.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("id", id)
                .body(productProxy.createPayment(product) ? "Success" : "Failed");
    }

    @PostMapping("/pay2")
    public ResponseEntity<?> pay2(@RequestBody Product product) {

        return productProxy.pay2(product);

    }
}
