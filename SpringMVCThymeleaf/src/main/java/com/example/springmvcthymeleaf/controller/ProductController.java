package com.example.springmvcthymeleaf.controller;

import com.example.springmvcthymeleaf.model.Product;
import com.example.springmvcthymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
public class ProductController {

    private final ProductService ps;

    @Autowired
    public ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping("/product")
    public String product() {
        return "product";

    }
    @PostMapping("/add")
    public String product(@ModelAttribute Product p, Model model) {

        p.setId(UUID.randomUUID().toString());
        ps.addProduct(p);
        model.addAttribute("products", ps.findAll());
        return "product";
    }

}
