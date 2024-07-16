package com.weather.domain.response;

import lombok.Data;

@Data
public class Weather {
   // public ArrayList<Object> @context;
    public String type;
    public Geometry geometry;
    public Props properties;
}
