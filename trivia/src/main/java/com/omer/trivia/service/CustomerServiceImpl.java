package com.omer.trivia.service;

import com.omer.trivia.apis.OpenTdbApi;
import com.omer.trivia.apis.OpenTdbResponse;
import com.omer.trivia.apis.dto.OpenTdbMapper;
import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.Player;
import com.omer.trivia.beans.Question;
import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import com.omer.trivia.reactDto.ClientMapper;
import com.omer.trivia.reactDto.GameDto;
import com.omer.trivia.reactDto.JoinGameStruct;
import com.omer.trivia.repository.GameRepository;
import com.omer.trivia.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final GameRepository gameRepository;
    private final OpenTdbApi openTdbApi;
    private final PlayerRepository playerRepository;

    public CustomerServiceImpl(GameRepository gameRepository, OpenTdbApi openTdbApi, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.openTdbApi = openTdbApi;
        this.playerRepository = playerRepository;
    }

    private OpenTdbResponse sendApiRequest(Game game) throws Exception {
        String URL = "https://opentdb.com/api.php?amount=" + game.getQuestionsPerRound();
        if (game.getCategory() != Category.ANY) URL = URL + "&category=" + (game.getCategory().ordinal()+9);
        if (game.getDifficulty() != Difficulty.ANY) URL = URL + "&difficulty=" + game.getDifficulty();
        URL = URL + "&type=multiple";
        System.out.println(URL);
        return openTdbApi.getTrivia(URL);
    }
    private void setGameQuestions(Game game) throws Exception {
        List<Question> questions = OpenTdbMapper.mapManyFromDto(sendApiRequest(game).getResults());
        questions.forEach(question -> question.setGame(game));
        (game).setQuestions(questions);
    }
    @Transactional
    private void addGameToRepo(Game game) {
        game = gameRepository.save(game);
        game.setUrl("game/multiplayer/"+game.getId());
    }

    /**
     * @param gameDto - received from client, expanded in External API, then saved to repository.
     * method is split into stages to optimise connection time (limit logic under @Transactional) and improve readability.
     */
    @Override
    public GameDto addGame(GameDto gameDto) throws Exception {
        if (gameDto == null) {
            System.out.println("gameDto is null at Service");
            throw new Exception("gameDto is null at Service");
        }
        Game game = ClientMapper.mapDtoToGame(gameDto);
        setGameQuestions(game);
        addGameToRepo(game);
        return ClientMapper.mapGameToDto(game);
    }

    @Override
    public GameDto getGame(int gameId) throws Exception {
        return ClientMapper.mapGameToDto(gameRepository.findById(gameId)
                .orElseThrow(()-> new RuntimeException("Game not found with id: " + gameId)));
    }

    @Override
    @Transactional
    public JoinGameStruct addPlayerToGame(int gameId) throws Exception {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found with id: " + gameId));
        String playerName = generateUniquePlayerName(game);
        Player player = Player.builder()
                .name(playerName)
                .host(false)
                .build();
        game.addPlayer(player);
        playerRepository.save(player);
        System.out.println(player);
        System.out.println(game);

        return new JoinGameStruct(ClientMapper.mapGameToDto(game), player);
    }

    @Override
    @Transactional
    public Player updatePlayer(Player player, int gameId) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game not found with id: " + gameId));
        game.removePlayer(player.getPlayerId());
        game.addPlayer(player);
        playerRepository.saveAndFlush(player);
        System.out.println(player.getGame());
        System.err.println(player.getName());
        return player;
    }

    private String generateUniquePlayerName(Game game) {
        int playerCount = game.getPlayers().size();
        return "guest" + (playerCount);
    }


}
