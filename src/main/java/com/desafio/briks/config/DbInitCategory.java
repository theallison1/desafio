package com.desafio.briks.config;

import com.desafio.briks.client.RestClientApi;
import com.desafio.briks.repository.RepoCategory;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DbInitCategory {

    @Autowired
    private final RestClientApi restClientApi;
    @Autowired
    private final RepoCategory repoCategory;
    public DbInitCategory(RestClientApi restClientApi, RepoCategory repoCategory) {

        this.restClientApi = restClientApi;
        this.repoCategory = repoCategory;
    }

    @PostConstruct
    private void postConstruct() throws JsonProcessingException {
        restClientApi.fetchDataFromApi();
    }
    @Scheduled(fixedRate = 600000)
    public void scheduleTaskWithFixedRate() throws JsonProcessingException {
        repoCategory.deleteAll();
        System.out.println("borrooo ");
        restClientApi.fetchDataFromApi();
        System.out.println("actualizo");
    }
}
