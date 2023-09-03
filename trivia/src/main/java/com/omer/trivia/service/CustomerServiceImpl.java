package com.omer.trivia.service;

import com.omer.trivia.apis.TriviaApiClient;
import com.omer.trivia.apis.TriviaResponse;
import com.omer.trivia.apis.dto.QuestionDto;
import com.omer.trivia.apis.dto.QuestionMapper;
import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.Question;
import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import com.omer.trivia.repository.CustomerRepository;
import com.omer.trivia.repository.GameRepository;
import com.omer.trivia.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final GameRepository gameRepository;
    private final QuestionRepository questionRepository;

    private final TriviaApiClient triviaApiClient;

    public CustomerServiceImpl(CustomerRepository customerRepository, QuestionRepository questionRepository, GameRepository gameRepository, TriviaApiClient triviaApiClient) {
        this.customerRepository = customerRepository;
        this.questionRepository = questionRepository;
        this.gameRepository = gameRepository;
        this.triviaApiClient = triviaApiClient;
    }

    private TriviaResponse sendApiRequest(Game game) throws Exception {
        String URL = "https://opentdb.com/api.php?amount=" + game.getQuestionsPerRound();
        if (game.getCategory() != Category.ANY) URL = URL + "&category=" + (game.getCategory().ordinal()+9);
        if (game.getDifficulty() != Difficulty.ANY) URL = URL + "&difficulty=" + game.getDifficulty();
        URL = URL + "&type=multiple";
        TriviaResponse triviaResponse = triviaApiClient.getTrivia(URL);

        System.out.println("question Dto's recieved from API:");
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
            throw new Exception("unexpected or no response from trivia Api");
        }
        return triviaResponse;
    }
    private List<Question> getQuestions(Game game) throws Exception {
        return QuestionMapper.mapManyFromDto(sendApiRequest(game).getResults());
    }

    @Override
    public Game addGame(Game game) throws Exception {
        if (game == null) {
            System.out.println("game is null at Service");
            throw new Exception("game is null at Service");
        }
        System.out.println(game);
        sendApiRequest(game);
        /*questionRepository.saveAll(getQuestions(game));
        List<Question> questions = questionRepository.findAll(); // TODO:: change to by game once game and questions are connected

        if (!questions.isEmpty()){
            int questionNumber = 1;
            for (Question question: questions) {
                System.out.println("Question " + questionNumber + ": " + question.getQuestionBody());
                System.out.println("1. " + question.getOption1());
                System.out.println("2. " + question.getOption2());
                System.out.println("3. " + question.getOption3());
                System.out.println("4. " + question.getOption4());
                System.out.println();
                System.out.println("correct answer: " + question.getCorrectAnswer());
                System.out.println("id: " + question.getId());
                System.out.println("category: " + question.getCategory());
                System.out.println("difficulty: " + question.getDifficulty());
                System.out.println("source: " + question.getSourceAPI());
                questionNumber++;
            }
        } else {
            System.out.println("No trivia questions received.");
        }*/

        game.setUrl("/game url"); // TODO: temp

        gameRepository.save(game);
        return game;
    }
}
