package com.up42.backendchallenge.feature.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@ApiModel(value = "ContextFeature model is to parse each object of static json array data")
public class ContextFeature {
    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private List<Feature> features;
}
