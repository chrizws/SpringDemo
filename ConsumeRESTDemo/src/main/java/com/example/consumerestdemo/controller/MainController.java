package com.example.consumerestdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class MainController {

    @PostMapping("/")
    public String post() {
        return "POST";
    }

    @GetMapping("/")
    public String get() {
        return "GET";
    }
}
