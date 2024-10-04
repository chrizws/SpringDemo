package com.example.springmvcthymeleaf.controller;

import com.example.springmvcthymeleaf.model.Product;
import com.example.springmvcthymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@org.springframework.web.bind.annotation.RestController
public class ProductRestController {

    @Autowired
    ProductService ps;

    @GetMapping("/hello")
    public String hello() {
        LocalDateTime time = LocalDateTime.now();
        return time.toString();
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<?> response(@PathVariable String name) {
        Product p = ps.findAll().stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().get();

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("category", "fruit")
                .header("season", "summer")
                .header("size", "6")
                .body(p);
    }


    @GetMapping("/err")
    public ResponseEntity<?> getError() {
        int n = ps.getProducts();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(n);
    }

    @GetMapping("/products")
    public ResponseEntity<?> product() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(ps.findAll());
    }

    @PostMapping("/pay")
    public boolean pay(@RequestBody Product p) {
        //System.out.println(ps.findAll().contains(p));
        return ps.findAll().contains(p);
    }

    @PostMapping("/pay2")
    public ResponseEntity<?> pay2(@RequestBody Product p) {

        return ResponseEntity.status(HttpStatus.OK)
                .header("pay2", "openfeign")
                .body(pay(p) ? ps.findAll() : false);
    }
}
