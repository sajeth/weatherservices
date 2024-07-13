package com.weather.service;

import com.weather.pojo.Weather;
import com.weather.pojo.response.RestResponse;
import com.weather.rest.ApiWeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherServiceImpl implements IWeather {

    @Autowired
    ApiWeatherClient apiWeatherClient;

    @Override
    public RestResponse<Object> getWeatherForecast() {
        Weather output;

        Optional<Weather> response = apiWeatherClient.getWeatherForecast().blockOptional();
        output = response.orElse(null);
        RestResponse.RestResponseBuilder<Object> x = RestResponse.builder().response(output);
        if (response.isEmpty()) {
            return x.code(500).status("FAILURE")
                    .build();
        } else {
            return x.code(200).status("SUCCESS")
                    .build();
        }

    }
}
