package com.xyz.weather.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JsonBackReference
    private CurrentWeather currentWeather;

    @JsonManagedReference
    @OneToMany(mappedBy="forecast",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("forecastday")
    private List<ForecastDay> forecastday;

    public Forecast() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public List<ForecastDay> getForecastday() {
        return forecastday;
    }

    public void setForecastDay(List<ForecastDay> forecastday) {
        this.forecastday = forecastday;
    }

}