package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Feature {
    private String type;
    private List<Double> bbox;
    private Geometry geometry;
    private Properties properties;
}
