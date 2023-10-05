package com.omer.trivia.service;

import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.Player;
import com.omer.trivia.reactDto.GameDto;
import com.omer.trivia.reactDto.JoinGameStruct;

public interface CustomerService {

    GameDto addGame(Game game) throws Exception;

    GameDto getGame(int gameId) throws Exception;

    JoinGameStruct addPlayerToGame(int gameId) throws Exception;

    Player updatePlayer(Player player, int gameId);
}
