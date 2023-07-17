package com.omer.trivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriviaController {
    private final TriviaApiClient triviaApiClient;

    @Autowired
    public TriviaController(TriviaApiClient triviaApiClient) {
        this.triviaApiClient = triviaApiClient;
    }

    @GetMapping("/trivia")
    public TriviaResponse getTrivia() {
        return triviaApiClient.getTrivia();
    }

}
