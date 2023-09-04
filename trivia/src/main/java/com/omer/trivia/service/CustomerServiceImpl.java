package com.omer.trivia.service;

import com.omer.trivia.apis.OpenTdbApi;
import com.omer.trivia.apis.OpenTdbResponse;
import com.omer.trivia.apis.dto.OpenTdbMapper;
import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.Question;
import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import com.omer.trivia.reactDto.ClientMapper;
import com.omer.trivia.reactDto.GameDto;
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

    private final OpenTdbApi openTdbApi;

    public CustomerServiceImpl(CustomerRepository customerRepository, QuestionRepository questionRepository, GameRepository gameRepository, OpenTdbApi openTdbApi) {
        this.customerRepository = customerRepository;
        this.questionRepository = questionRepository;
        this.gameRepository = gameRepository;
        this.openTdbApi = openTdbApi;
    }

    private OpenTdbResponse sendApiRequest(Game game) throws Exception {
        String URL = "https://opentdb.com/api.php?amount=" + game.getQuestionsPerRound();
        if (game.getCategory() != Category.ANY) URL = URL + "&category=" + (game.getCategory().ordinal()+9);
        if (game.getDifficulty() != Difficulty.ANY) URL = URL + "&difficulty=" + game.getDifficulty();
        URL = URL + "&type=multiple";
        return openTdbApi.getTrivia(URL);
    }
    private List<Question> getQuestions(Game game) throws Exception {
        List<Question> questions = OpenTdbMapper.mapManyFromDto(sendApiRequest(game).getResults());
        questions.forEach(question -> question.setGame(game));
        return questions;
    }

    @Override
    public GameDto addGame(Game game) throws Exception {
        if (game == null) {
            System.out.println("game is null at Service");
            throw new Exception("game is null at Service");
        }
        System.out.println(game);
        game.setQuestions(getQuestions(game));
        game.setUrl("/game url"); // TODO: temp
        gameRepository.save(game);
        return ClientMapper.mapToGameDto(game);
    }
}
