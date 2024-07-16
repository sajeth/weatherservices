package com.weather.service;

import com.weather.domain.response.Weather;
import com.weather.domain.RestResponse;
import com.weather.rest.ApiWeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements IWeather {

    @Autowired
    ApiWeatherClient apiWeatherClient;

    @Override
    public RestResponse<Object> getWeatherForecast(Double latitude,Double longitude) {

        Weather response = apiWeatherClient.getWeatherForecast(latitude,longitude).blockFirst();
        RestResponse.RestResponseBuilder<Object> x = RestResponse.builder().response(response);
        if (null==response) {
            return x.code(500).status("FAILURE")
                    .build();
        } else {
            return x.code(200).status("SUCCESS")
                    .build();
        }

    }
}
