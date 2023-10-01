package com.omer.trivia.service;

import com.omer.trivia.beans.Game;
import com.omer.trivia.reactDto.GameDto;

public interface CustomerService {

    GameDto addGame(Game game) throws Exception;

    GameDto getGame(int gameId) throws Exception;

}
