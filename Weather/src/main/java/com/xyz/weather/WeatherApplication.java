package com.xyz.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(WeatherApplication.class, args);
    }

}
