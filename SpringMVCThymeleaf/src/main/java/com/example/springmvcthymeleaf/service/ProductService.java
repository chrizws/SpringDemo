package com.example.springmvcthymeleaf.service;

import com.example.springmvcthymeleaf.exception.NotEnoughProductsException;
import com.example.springmvcthymeleaf.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }
    public boolean addProduct(Product p) {
        return products.add(p);
    }

    public List<Product> findAll() {
        return products;
    }

    public int getProducts() {
        throw new NotEnoughProductsException();
    }


}
