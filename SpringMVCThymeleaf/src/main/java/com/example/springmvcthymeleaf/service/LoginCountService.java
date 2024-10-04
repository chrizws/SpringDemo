package com.example.springmvcthymeleaf.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.*;

@Service
@ApplicationScope
public class LoginCountService {

    private int count;

    public void inc() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void clearCount() {
        count = 0;
    }
}
