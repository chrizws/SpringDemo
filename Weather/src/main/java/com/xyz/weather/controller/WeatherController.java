package com.xyz.weather.controller;

import com.xyz.weather.model.CurrentWeather;
import com.xyz.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class WeatherController {

    private final WeatherService ws;

    @Autowired
    public WeatherController(WeatherService ws) {
        this.ws = ws;
    }

    @GetMapping("/")
    public String home(Model model) {

        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String location, Model model) {
        return getCurrentWeather(location, 1, "no", "no", model);
    }

    @GetMapping("/search/{location}")
    public String getCurrentWeather(@PathVariable String location,
                                    @RequestParam(value = "days", required = false, defaultValue = "1") int days,
                                    @RequestParam (required = false, defaultValue = "no") String aqi,
                                    @RequestParam (required = false, defaultValue = "no") String alerts,
                                    Model model) {

        CurrentWeather weather = ws.getCurrentWeather(location, days, aqi, alerts);
        ws.addCurrentWeather(weather);

        Iterable<CurrentWeather> weatherList = ws.getAllCurrentWeatherSearches();
        model.addAttribute("weather", weather);
        model.addAttribute("history", weatherList);

        return "index";
        //var response = proxy.getCurrentWeather(API_KEY, search, aqi);
        //ObjectMapper mapper = new ObjectMapper();

//        return ResponseEntity.ok()
//                .body(ws.getCurrentWeather(location));

        //var weather = rt.getForObject(URL, Object.class);

    }


}
