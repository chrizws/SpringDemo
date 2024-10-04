package com.xyz.weather.service;

import com.xyz.weather.model.CurrentWeather;
import com.xyz.weather.proxy.WeatherProxy;
import com.xyz.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private RestTemplate restTemplate;
    private WeatherRepository weatherRepository;

    private WeatherProxy weatherProxy;

    @Value("${api}")
    private String API_KEY;

    @Autowired
    public WeatherService(RestTemplate restTemplate, WeatherRepository weatherRepository, WeatherProxy weatherProxy) {
        this.restTemplate = restTemplate;
        this.weatherRepository = weatherRepository;
        this.weatherProxy = weatherProxy;
    }


    //verify location or use auto complete?

    //get current weather
    public CurrentWeather getCurrentWeather(String location, int days, String aqi, String alerts) {


        //final String URL = "http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + location;
        //CurrentWeather cw = restTemplate.getForObject(URL, CurrentWeather.class);

        CurrentWeather cw = weatherProxy.getCurrentWeather(API_KEY, location, days, aqi, alerts);

        return cw;

    }

    public void addCurrentWeather(CurrentWeather cw) {
        weatherRepository.save(cw);
    }
    public Iterable<CurrentWeather> getAllCurrentWeatherSearches() {
        return weatherRepository.findAll();
    }
    public CurrentWeather getCurrentWeatherById(int id) {
        return weatherRepository.findById(id).get();
    }

    public void deleteAllCurrentWeather() {
        weatherRepository.deleteAll();
    }
}
