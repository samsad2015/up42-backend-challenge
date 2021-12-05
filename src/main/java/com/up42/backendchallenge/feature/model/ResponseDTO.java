package com.up42.backendchallenge.feature.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String id;
    private Long timestamp;
    private Long beginViewingDate;
    private Long endViewingDate;
    private String missionName;
}
