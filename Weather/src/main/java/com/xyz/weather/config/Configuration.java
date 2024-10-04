package com.xyz.weather.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@org.springframework.context.annotation.Configuration
@EnableFeignClients (basePackages = "com.xyz.weather.proxy")
public class Configuration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
