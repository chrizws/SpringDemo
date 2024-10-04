package com.example.springdemo;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Student {

    @Autowired
    @Qualifier("lap2")
    Laptop laptop;

    public Student() {
        System.out.println("student constructor called");
    }

    public void setLaptop(Laptop lap) {
        laptop = lap;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    @PostConstruct //called after constructor and fields are initialized
    public void init() {
        System.out.println("@PostConstruct in Student called called");
    }


}
