package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Enrichment {
    private NaturalLanguage naturallanguage;
    public List<Geoname> geonames;
}
