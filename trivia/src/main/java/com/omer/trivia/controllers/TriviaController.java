package com.omer.trivia.controllers;

import com.omer.trivia.apis.OpenTdbApi;
import com.omer.trivia.apis.OpenTdbResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriviaController {
    private final OpenTdbApi openTdbApi;

    @Autowired
    public TriviaController(OpenTdbApi openTdbApi) {
        this.openTdbApi = openTdbApi;
    }

    @GetMapping("/trivia")
    public OpenTdbResponse getTrivia(String API_URL) {
        return openTdbApi.getTrivia(API_URL);
    }

}
