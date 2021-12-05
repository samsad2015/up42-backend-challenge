package com.up42.backendchallenge.feature.service;


import com.up42.backendchallenge.feature.dto.ResponseDTO;

import java.util.List;

public interface FeatureService {


    ResponseDTO findFeatureById(String Id);

    byte[] findQuickLookById(String Id);

    List<ResponseDTO> findAllFeatures();
}
