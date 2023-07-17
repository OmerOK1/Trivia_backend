package com.omer.trivia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TriviaApplicationTests implements CommandLineRunner {

    private final TriviaApiClient triviaApiClient;

    public TriviaApplicationTests(TriviaApiClient triviaApiClient) {
        this.triviaApiClient = triviaApiClient;
    }

    @Override
    public void run(String... args) {
        TriviaResponse triviaResponse = triviaApiClient.getTrivia();

        if (triviaResponse != null && triviaResponse.getResults() != null && !triviaResponse.getResults().isEmpty()) {
            int questionNumber = 1;
            for (TriviaResult triviaResult : triviaResponse.getResults()) {
                System.out.println("Question " + questionNumber + ": " + triviaResult.getQuestion());
                System.out.println("Options: " + triviaResult.getOptions());
                System.out.println();
                questionNumber++;
            }
        } else {
            System.out.println("No trivia questions received.");
        }
    }
}
