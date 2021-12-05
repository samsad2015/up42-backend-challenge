package com.up42.backendchallenge.feature.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Geometry {

   public String type;
   public List<List<List<Double>>> coordinates;
   public GeographicBoundingPolygon geographicBoundingPolygon;
   public boolean global;
   public CenterPoint centerPoint;
}
