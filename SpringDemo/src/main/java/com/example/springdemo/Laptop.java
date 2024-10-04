package com.example.springdemo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Aspect
public class Laptop {

    public Laptop() {
        System.out.println("laptop constructor called");
    }

    public String toString() {
        return "laptop";
    }
}
