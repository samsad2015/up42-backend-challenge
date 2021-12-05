package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Properties {
    private String id;
    private String uid;
    private Object timestamp;
    private Object timeStamp;
    private Centroid centroid;
    private Visibility visibility;
    private Object illumination;
    private Production production;
    private Archive archive;
    private SpatialCoverage spatialCoverage;
    private Enrichment enrichment;
    private Identification identification;
    private Object transmission;
    private Object contentDescription;
    private Acquisition acquisition;
    private Orbit orbit;
    private State state;
    private Object attitude;
    private String quicklook;
    public Object quality;
    public Object target;
    public Object provider;

}
