package com.omer.trivia.tests;

import com.omer.trivia.apis.TriviaApiClient;
import com.omer.trivia.apis.TriviaResponse;
import com.omer.trivia.apis.TriviaResult;
import com.omer.trivia.beans.Game;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TriviaApiTests implements CommandLineRunner {

    private final TriviaApiClient triviaApiClient;

    private final EntityFactory entityFactory = new EntityFactory();

    public TriviaApiTests(TriviaApiClient triviaApiClient) {
        this.triviaApiClient = triviaApiClient;
    }

    @Override
    public void run(String... args) {

        Game game = entityFactory.factorRandomGame();

        System.out.println(game);
        String API_URL = "https://opentdb.com/api.php?amount=" + game.getQuestionsPerRound()+"&category=" + (game.getCategory().ordinal()+9) +"&difficulty=" + game.getDifficulty()+ "&type=multiple";

        System.out.println(API_URL);

        TriviaResponse triviaResponse = triviaApiClient.getTrivia(API_URL);

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
