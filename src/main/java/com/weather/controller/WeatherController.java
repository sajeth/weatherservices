package com.weather.controller;

import com.weather.pojo.response.RestResponse;
import com.weather.service.IWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    IWeather iWeather;

    @GetMapping(value = "/latest",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody RestResponse<Object> getWeather() {
        return iWeather.getWeatherForecast();
    }
}
