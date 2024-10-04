package com.example.springmvcthymeleaf.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler (NotEnoughProductsException.class)
    public ResponseEntity<?> exceptionHandler() {
        ErrorDetails error = new ErrorDetails("Not Enough Products");
        return ResponseEntity
                .badRequest()
                .body(error.getError());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> exception() {
        return ResponseEntity
                .badRequest()
                .body("product not found");
    }
}
