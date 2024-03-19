package com.desafio.briks.client;

import com.desafio.briks.model.Category;
import com.desafio.briks.repository.RepoCategory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestClientApi {


    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;
    private final RepoCategory category;

    @Autowired
    public RestClientApi(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper, RepoCategory category) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;

        this.category = category;
    }


    public List<Category> fetchDataFromApi() throws JsonProcessingException {
        String url = "https://api.develop.bricks.com.ar/loyalty/category/producer";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        List<Category> mapaJson = objectMapper.readValue(response.getBody(), new TypeReference<>() {
        });

        try {
            for (Category category1 : mapaJson
            ) {
                Category category2 = new Category(category1.getId(), category1.getName(), category1.getCode(), category1.getDescription(), category1.getIcon());
                category.save(category2);
            }

        } catch (Exception ignored) {
        }

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Response from API: " + response);

            return mapaJson;
        } else {
            return new ArrayList<>();
        }
    }
}