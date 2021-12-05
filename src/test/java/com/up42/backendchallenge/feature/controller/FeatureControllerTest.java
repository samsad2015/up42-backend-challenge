package com.up42.backendchallenge.feature.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FeatureControllerTest {

    @InjectMocks
    private FeatureController featureController;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(featureController).build();
    }

    @Test
    public void testGetAllFeatures() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/features").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andExpect(jsonPath("$.*", Matchers.hasSize(14)));
    }

    @Test
    public void testGetFeatureById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/features/{id}", "39c2f29e-c0f8-4a39-a98b-deed547d6aea").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andExpect(jsonPath("$.missionName", Matchers.is("Sentinel-1B")));
    }

    @Test
    public void testQuicklookById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/features/{id}/quicklook", "39c2f29e-c0f8-4a39-a98b-deed547d6aea").contentType(MediaType.IMAGE_PNG_VALUE)).andExpect(status().isOk()).andExpect(header().string("Content-Type","image/png"));
    }
}