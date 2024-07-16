package com.weather.controller;

import com.weather.domain.RestResponse;
import com.weather.service.IWeather;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    IWeather iWeather;

    @GetMapping(value = "/latest",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody RestResponse<Object> getWeather(@RequestParam("lattitude")@Positive Double lattitude, @RequestParam("longitude")@Positive Double longitude) {
        return iWeather.getWeatherForecast(lattitude,longitude);
    }
}
