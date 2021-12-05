package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Centroid {
    private String type;
    public List<Double> coordinates;
}
