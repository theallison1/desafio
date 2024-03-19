package com.desafio.briks.client;

import com.desafio.briks.model.Category;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class RestClientApi {


    private final RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    public RestClientApi(RestTemplateBuilder restTemplateBuilder,ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;

    }



    public List<Category> fetchDataFromApi() throws JsonProcessingException {
        String url = "https://api.develop.bricks.com.ar/loyalty/category/producer";

        ResponseEntity<String>response = restTemplate.getForEntity(url, String.class);

        List<Category> mapaJson = objectMapper.readValue(response.getBody(), new TypeReference<List<Category>>() {});

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Response from API: " + response);
            return mapaJson;
        } else {
            return new ArrayList<>();
        }
    }
}