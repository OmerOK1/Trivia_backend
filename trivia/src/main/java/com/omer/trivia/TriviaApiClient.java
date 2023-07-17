package com.omer.trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TriviaApiClient {

    private static final String API_URL = "https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple";

    private final RestTemplate restTemplate;

    @Autowired
    public TriviaApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TriviaResponse getTrivia() {
        ResponseEntity<TriviaResponse> responseEntity = restTemplate.getForEntity(API_URL, TriviaResponse.class);
        return responseEntity.getBody();
    }
}
