package com.example.consumerestdemo.proxy;

import com.example.consumerestdemo.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient (name="payment", url="${url}")
public interface ProductProxy {

    @PostMapping("/pay")
    boolean createPayment(@RequestBody Product product);

    @PostMapping("/pay2")
    ResponseEntity<?> pay2(@RequestBody Product p);
}
