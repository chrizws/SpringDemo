package com.xyz.weather.proxy;

import com.xyz.weather.model.CurrentWeather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="current", url="${url}")
public interface WeatherProxy {

    @GetMapping("/v1/forecast.json")
    CurrentWeather getCurrentWeather(@RequestParam String key, @RequestParam String q,
                                     @RequestParam int numDays,
                                     @RequestParam String aqi,
                                     @RequestParam String alerts);
}
