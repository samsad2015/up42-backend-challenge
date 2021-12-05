package com.up42.backendchallenge.feature.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Services {

    private boolean wmts;
    private String download;
    private boolean wcs;
    private boolean wms;
}
