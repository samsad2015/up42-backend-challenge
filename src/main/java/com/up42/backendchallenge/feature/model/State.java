package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class State {
    private Resources resources;
    private Services services;
    private Object insertionDate;
    public String name;
    public List<County> counties;
}
