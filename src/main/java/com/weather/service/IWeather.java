package com.weather.service;

import com.weather.pojo.response.RestResponse;

public interface IWeather {
    public RestResponse<Object> getWeatherForecast();
}
