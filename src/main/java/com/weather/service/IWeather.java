package com.weather.service;

import com.weather.domain.RestResponse;

public interface IWeather {
    RestResponse<Object> getWeatherForecast(Double lattitude, Double longitude);
}
