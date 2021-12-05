package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeographicBoundingPolygon{
    public List<List<List<Double>>> coordinates;
    public String type;
}