package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Geoname{
    public String name;
    public List<State> states;
}