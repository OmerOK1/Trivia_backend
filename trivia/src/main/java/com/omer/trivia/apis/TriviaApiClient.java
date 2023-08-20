package com.omer.trivia.apis;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class TriviaApiClient {
    //    private static String API_URL = "https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple";

    private final RestTemplate restTemplate;

    public TriviaResponse getTrivia(String API_URL) {
        ResponseEntity<TriviaResponse> responseEntity = restTemplate.getForEntity(API_URL, TriviaResponse.class);
        return responseEntity.getBody();
    }
}
