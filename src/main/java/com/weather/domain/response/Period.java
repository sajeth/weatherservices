package com.weather.domain.response;

import lombok.Data;

import java.util.Date;
@Data
public class Period{
    private int number;
    private String name;
    private Date startTime;
    private Date endTime;
    private boolean isDaytime;
    private int temperature;
    private String temperatureUnit;
    private String temperatureTrend;
    private ProbabilityOfPrecipitation probabilityOfPrecipitation;
    private String windSpeed;
    private String windDirection;
    private String icon;
    private String shortForecast;
    private String detailedForecast;
}
