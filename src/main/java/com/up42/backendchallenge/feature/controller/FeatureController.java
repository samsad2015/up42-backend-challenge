package com.up42.backendchallenge.feature.controller;

import com.google.common.io.ByteSource;
import com.up42.backendchallenge.feature.model.ResponseDTO;
import com.up42.backendchallenge.feature.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FeatureController {

    @Autowired
    FeatureService featureService;

    @GetMapping(value = "/features", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResponseDTO>> findFeatures() {
        return ResponseEntity.status(HttpStatus.OK).body(featureService.findAllFeatures());
    }

    @GetMapping(value = "/features/{id}")
    public ResponseEntity<ResponseDTO> findFeatureById(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(featureService.findFeatureById(id));
    }

    @GetMapping(value = "/features/{id}/quicklook", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> findQuickLookById(@PathVariable("id") String id) throws IOException {
        byte[] byt = Base64.getDecoder().decode(featureService.findQuickLookById(id));
        return ResponseEntity.status(HttpStatus.OK).body(byt);
    }
}
