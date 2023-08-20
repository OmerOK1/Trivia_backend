package com.omer.trivia.tests;

import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;



public class EntityFactory {
    public Game factorRandomGame() {
        return Game.builder()
                .url("placeholder url")
                .answerTimeLimit((int)(Math.random()*20)+5)
                .title("place holder title number " + (int)(Math.random()*99)+1)
                .difficulty(Difficulty.values()[(int)(Math.random()*Difficulty.values().length)])
                .category(Category.values()[(int)(Math.random()*Category.values().length)])
                .questionsPerRound((int)(Math.random()*10)+1)
                .build();
    }
}
