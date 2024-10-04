package com.example.springmvcthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Component
@RequestScope
public class LoginProcessor {

    private final UserManagementService ums;
    private String username;
    private String password;
    private int count = 0;

    @Autowired
    public LoginProcessor(UserManagementService ums) {
        this.ums = ums;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        username = user;
    }

    public void setPass(String pass) {
        password = pass;
    }

    public String getPassword() {
        return password;
    }
    public boolean isAuthenticated() {
        if (username.equalsIgnoreCase("a")
                && password.equalsIgnoreCase("a")) {

            ums.setUsername(username);
            return true;
        }

        return false;
    }

    public int incCount() {
        count++;
        return count;
    }

    public int getCount() {
        return count;
    }
}
