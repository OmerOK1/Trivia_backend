package com.omer.trivia.tests;

import com.omer.trivia.apis.OpenTdbApi;
import com.omer.trivia.apis.OpenTdbResponse;
import com.omer.trivia.apis.dto.QuestionDtoOpenTdb;
import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.Player;
import com.omer.trivia.controllers.CustomerController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate;

//@Component
public class TriviaApiTests implements CommandLineRunner {
    private final CustomerController customerController;
    public TriviaApiTests(final CustomerController customerController) {
        this.customerController = customerController;
    }

    private void triviaTest() {
        OpenTdbApi openTdbApi = new OpenTdbApi(new RestTemplate());

        Game game = EntityFactory.factorRandomGame();

        System.out.println(game);
        String API_URL = "https://opentdb.com/api.php?amount=" + game.getQuestionsPerRound()+"&category=" + (game.getCategory().ordinal()+9) +"&difficulty=" + game.getDifficulty()+ "&type=multiple";

        System.out.println(API_URL);

        OpenTdbResponse openTdbResponse = openTdbApi.getTrivia(API_URL);

        if (openTdbResponse != null && openTdbResponse.getResults() != null && !openTdbResponse.getResults().isEmpty()) {
            int questionNumber = 1;
            for (QuestionDtoOpenTdb triviaResult : openTdbResponse.getResults()) {

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
        try {
            customerController.addPlayerToGame(1);
            customerController.addPlayerToGame(1);
            customerController.addPlayerToGame(1);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            customerController.updatePlayer(Player.builder().playerId(1).name("jon").build(), 1 );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(String... args) {
        //triviaTest();
        //controllerTest();
    }
}
