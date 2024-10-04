package com.example.springmvcthymeleaf.exception;

import java.util.*;

public class ErrorDetails {

    private String error;

    public ErrorDetails(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
