package com.weather.pojo;

import lombok.Data;

@Data
public class Daily {
    private String day_name;
    private Double temp_high_celsius;
    private String forecast_blurp;
}
