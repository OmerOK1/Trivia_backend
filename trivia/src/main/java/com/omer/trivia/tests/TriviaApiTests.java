package com.omer.trivia.tests;

import com.omer.trivia.apis.TriviaApiClient;
import com.omer.trivia.apis.TriviaResponse;
import com.omer.trivia.apis.dto.QuestionDto;
import com.omer.trivia.beans.Game;
import com.omer.trivia.controllers.CustomerController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TriviaApiTests implements CommandLineRunner {
    private final CustomerController customerController;
    public TriviaApiTests(final CustomerController customerController) {
        this.customerController = customerController;
    }

    private void triviaTest() {
        TriviaApiClient triviaApiClient = new TriviaApiClient(new RestTemplate());

        Game game = EntityFactory.factorRandomGame();

        System.out.println(game);
        String API_URL = "https://opentdb.com/api.php?amount=" + game.getQuestionsPerRound()+"&category=" + (game.getCategory().ordinal()+9) +"&difficulty=" + game.getDifficulty()+ "&type=multiple";

        System.out.println(API_URL);

        TriviaResponse triviaResponse = triviaApiClient.getTrivia(API_URL);

        if (triviaResponse != null && triviaResponse.getResults() != null && !triviaResponse.getResults().isEmpty()) {
            int questionNumber = 1;
            for (QuestionDto triviaResult : triviaResponse.getResults()) {

                System.out.println("Question " + questionNumber + ": " + triviaResult.getQuestion());
                System.out.println("Options: " + triviaResult.getOptions());
                System.out.println();
                questionNumber++;
            }
        } else {
            System.out.println("No trivia questions received.");
        }
    }

    private void controllerTest() {
        Game game = EntityFactory.factorRandomGame();
        Game anyDifficulty = EntityFactory.factorGameWithAnyAsDifficulty();
        Game anyCategory = EntityFactory.factorGameWithAnyAsCategory();
        try {
            customerController.addGame(game);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            customerController.addGame(anyCategory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            customerController.addGame(anyDifficulty);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(String... args) {
        //triviaTest();
        controllerTest();
    }
}
