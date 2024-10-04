package com.example.consumerestdemo.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@EnableFeignClients (basePackages = "com.example.consumerestdemo.proxy")
public class Config {

}
