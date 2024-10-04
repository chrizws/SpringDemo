package com.xyz.weather.repository;

import com.xyz.weather.model.CurrentWeather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherRepository extends CrudRepository<CurrentWeather, Integer> {


}
