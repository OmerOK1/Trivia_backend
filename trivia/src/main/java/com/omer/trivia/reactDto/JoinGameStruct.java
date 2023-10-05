package com.omer.trivia.reactDto;

import com.omer.trivia.beans.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinGameStruct {
    private GameDto game;
    private Player player;
}
