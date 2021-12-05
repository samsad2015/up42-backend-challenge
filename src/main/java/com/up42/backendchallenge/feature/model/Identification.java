package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Identification {
    private String profile;
    private String externalId;
    private String collection;
    private String type;
    private Object dataset;

}
