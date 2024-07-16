package com.weather.domain.response;

import lombok.Data;

@Data
public class ProbabilityOfPrecipitation{
    private String unitCode;
    private int value;
}
