package com.xyz.weather.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class ForecastDay {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Forecast forecast;

    private String date;

    @Embedded
    private Day day;

    public ForecastDay() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    @Embeddable
    static class Day {
        private double maxtemp_c;
        private double maxtemp_f;
        private double mintemp_c;
        private double mintemp_f;

        public Day() {}

        public double getMaxtemp_c() {
            return maxtemp_c;
        }

        public void setMaxtemp_c(double maxtemp_c) {
            this.maxtemp_c = maxtemp_c;
        }

        public double getMaxtemp_f() {
            return maxtemp_f;
        }

        public void setMaxtemp_f(double maxtemp_f) {
            this.maxtemp_f = maxtemp_f;
        }

        public double getMintemp_c() {
            return mintemp_c;
        }

        public void setMintemp_c(double mintemp_c) {
            this.mintemp_c = mintemp_c;
        }

        public double getMintemp_f() {
            return mintemp_f;
        }

        public void setMintemp_f(double mintemp_f) {
            this.mintemp_f = mintemp_f;
        }
    }
}
