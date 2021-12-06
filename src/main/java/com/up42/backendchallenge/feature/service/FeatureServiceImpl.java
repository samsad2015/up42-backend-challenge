package com.up42.backendchallenge.feature.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.up42.backendchallenge.feature.dto.ResponseDTO;
import com.up42.backendchallenge.feature.exception.ResourceNotFoundCustomException;
import com.up42.backendchallenge.feature.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * Service implementation for Feature.
 *
 * @author Samsad Hasan
 * @version 1.0
 * @since 2021-12-11
 */

@Service
public class FeatureServiceImpl implements FeatureService {
    @Value("${source.data.json}")
    String staticJsonData;


    @Autowired
    private ResourceLoader resourceLoader;

    private static List<ContextFeature> contexts = new ArrayList<>();


    @PostConstruct
    private void load() throws IOException {
        //Mapper to map the json object
        ObjectMapper mapper = new ObjectMapper();
        // Forcing to accept case-sensitive json nodes. Example : timestamp & timeStamp in the static json payload
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        Resource resource = resourceLoader.getResource(staticJsonData);
        InputStream inputStream = resource.getInputStream();
        byte[] fileData = FileCopyUtils.copyToByteArray(inputStream);
        String outputString = new String(fileData);
        List<ContextFeature> list = mapper.readValue(outputString, new TypeReference<List<ContextFeature>>() {
        });
        contexts.addAll(list);
    }

    /**
     * Find quicklook by properties ID
     *
     * @param Id String
     * @return ResponseDTO
     */
    @Override
    public ResponseDTO findFeatureById(String Id) {
        ContextFeature context = contexts.stream().filter(contextFeature -> checkIfFeatureMatches(contextFeature, Id) != null).findAny().orElse(null);
        if (context == null) throw new ResourceNotFoundCustomException("No resource found with " + Id);
        Properties properties = checkIfFeatureMatches(context, Id).getProperties();
        Acquisition acquisition = properties.getAcquisition();
        return new ResponseDTO(properties.getId(), objectToLongParser(properties.getTimestamp()), objectToLongParser(acquisition.getBeginViewingDate()), objectToLongParser(acquisition.getEndViewingDate()), acquisition.getMissionName());
    }

    /**
     * Find quicklook by properties ID
     *
     * @param Id String
     * @return bytes[]
     */

    @Override
    public byte[] findQuickLookById(String Id) {
        ContextFeature context = contexts.stream().filter(contextFeature -> checkIfFeatureMatches(contextFeature, Id) != null).findAny().orElse(null);
        if (context == null) throw new ResourceNotFoundCustomException("No quicklook image found with " + Id);
        Properties properties = checkIfFeatureMatches(context, Id).getProperties();
        return Base64.getDecoder().decode(properties.getQuicklook());
    }


    /**
     * Find All Features
     *
     * @return List
     */
    @Override
    public List<ResponseDTO> findAllFeatures() {
        List<ResponseDTO> responseDTOList = new ArrayList<>();
        // Looping through the static contexts
        for (ContextFeature contextFeature : contexts) {
            // building the response DTO
            ResponseDTO res = this.findFeatureById(contextFeature.getFeatures().stream().filter(feature -> feature.getProperties() != null).findAny().orElse(null).getProperties().getId());
            responseDTOList.add(res);
        }
        return responseDTOList;
    }

    /**
     * Filter feature by matching id
     *
     * @param context ContextFeature
     * @param Id      String
     * @return Feature
     */
    private Feature checkIfFeatureMatches(ContextFeature context, String Id) {
        return context.getFeatures().stream().filter(feature -> Id.equals(feature.getProperties().getId())).findAny().orElse(null);
    }

    /**
     * Object to Long parser followed by String
     *
     * @param obj Object
     * @return Long
     */
    private Long objectToLongParser(Object obj) {
        return Long.parseLong(String.valueOf(obj));
    }

}
