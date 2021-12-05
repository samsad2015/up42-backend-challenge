package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SpatialCoverage {

    private Object verticality;
    private Geometry geometry;
    private Long timeStamp;
    private String uid;


}
