package com.weather.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
@Data
public class Props{
    private String units;
    private String forecastGenerator;
    private Date generatedAt;
    private Date updateTime;
    private String validTimes;
    private Elevation elevation;
    private ArrayList<Period> periods;
}
