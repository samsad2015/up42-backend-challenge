package com.up42.backendchallenge.feature.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@Service
public class FeatureServiceImpl implements FeatureService {
    @Value("${source.data.json}")
    String jsonConfigFolder;


    @Autowired
    private ResourceLoader resourceLoader;

    private static List<ContextFeature> contexts = new ArrayList<>();

    @PostConstruct
    private void load() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        Resource resource = resourceLoader.getResource(jsonConfigFolder);
        InputStream inputStream = resource.getInputStream();
        byte[] fileData = FileCopyUtils.copyToByteArray(inputStream);
        String outputString = new String(fileData);
        List<ContextFeature> list = mapper.readValue(outputString, new TypeReference<List<ContextFeature>>() {
        });
        contexts.addAll(list);
    }

    @Override
    public ResponseDTO findFeatureById(String Id) {
        ContextFeature context = contexts.stream().filter(contextFeature -> checkIfFeatureMatches(contextFeature, Id) != null).findAny().orElse(null);
        Properties properties = checkIfFeatureMatches(context, Id).getProperties();
        Acquisition acquisition = properties.getAcquisition();
        return new ResponseDTO(properties.getId(), objectToLongParser(properties.getTimestamp()), objectToLongParser(acquisition.getBeginViewingDate()), objectToLongParser(acquisition.getEndViewingDate()), acquisition.getMissionName());
    }

    @Override
    public String findQuickLookById(String Id) {
        ContextFeature context = contexts.stream().filter(contextFeature -> checkIfFeatureMatches(contextFeature, Id) != null).findAny().orElse(null);
        Properties properties = checkIfFeatureMatches(context, Id).getProperties();
        return properties.getQuicklook();//"data:image/png;base64," +
    }


    @Override
    public List<ResponseDTO> findAllFeatures() {
        List<ResponseDTO> responseDTOList = new ArrayList<>();
        for (ContextFeature contextFeature : contexts) {
            ResponseDTO res = this.findFeatureById(contextFeature.getFeatures().stream().filter(feature -> feature.getProperties() != null).findAny().orElse(null).getProperties().getId());
            responseDTOList.add(res);
        }
        return responseDTOList;
    }

    private Feature checkIfFeatureMatches(ContextFeature context, String Id) {
        return context.getFeatures().stream().filter(feature -> Id.equals(feature.getProperties().getId())).findAny().orElse(null);
    }

    private Long objectToLongParser(Object obj) {
        return Long.parseLong(String.valueOf(obj));
    }

}
