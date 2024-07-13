package com.weather.pojo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Geometry{
    private String type;
    private ArrayList<ArrayList<ArrayList<Double>>> coordinates;
}
