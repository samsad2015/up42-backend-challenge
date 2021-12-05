package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ContextFeature {
    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private List<Feature> features;
}
