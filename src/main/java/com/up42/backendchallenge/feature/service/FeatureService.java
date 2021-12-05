package com.up42.backendchallenge.feature.service;


import com.up42.backendchallenge.feature.model.ResponseDTO;

import java.util.List;

public interface FeatureService {


    ResponseDTO findFeatureById(String Id);

    String findQuickLookById(String Id);

    List<ResponseDTO> findAllFeatures();
}
