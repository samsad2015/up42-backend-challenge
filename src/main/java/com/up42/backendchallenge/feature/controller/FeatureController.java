package com.up42.backendchallenge.feature.controller;

import com.up42.backendchallenge.feature.dto.ResponseDTO;
import com.up42.backendchallenge.feature.service.FeatureService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value = "FeatureController for retrieving of features", tags = {"All"})
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @ApiOperation(value = "API to GET all features", notes = "Get all features", tags = {"getFeatures"}, response = ResponseDTO.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval", response = List.class)})
    @GetMapping(value = "/features", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResponseDTO>> getFeatures() {
        return ResponseEntity.status(HttpStatus.OK).body(featureService.findAllFeatures());
    }

    @ApiOperation(value = "API to GET feature by Id", notes = "Search any feature by Id", tags = {"getFeatureById"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval for specific feature by Id", response = List.class)})
    @GetMapping(value = "/features/{id}")
    public ResponseEntity<ResponseDTO> getFeatureById(@ApiParam(value = "Properties ID is required to use this api.", required = true) @PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(featureService.findFeatureById(id));
    }

    @ApiOperation(value = "API to GET quicklook image by Id", notes = "Quicklook base64 encoded string converted into image/png format", tags = {"getQuicklookById"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful retrieval for specific quicklook image by Id", response = List.class)})
    @GetMapping(value = "/features/{id}/quicklook", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getQuicklookById(@ApiParam(value = "Properties ID is required to use this api.", required = true) @PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(featureService.findQuickLookById(id));
    }
}
