package com.omer.trivia.tests;

import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import com.omer.trivia.beans.enums.GameMode;
import com.omer.trivia.beans.enums.Layout;


public class EntityFactory {


    private static Game factorGame(Category category, Difficulty difficulty, GameMode gameMode) {
        return Game.builder()
                .url("placeholder url")
                .answerTimeLimit((int) (Math.random() * 20) + 5)
                .title("place holder title number " + (int) (Math.random() * 99) + 1)
                .difficulty(difficulty)
                .gameMode(gameMode)
                .category(category)
                .questionsPerRound((int) (Math.random() * 10) + 1)
                .layout(Layout.NORMAL)
                .isMultiplayer(false)
                .build();
    }

    public static Game factorGameWithAnyAsCategory() {
        return factorGame(Category.ANY, Difficulty.values()[(int) (Math.random() * Difficulty.values().length)], GameMode.values()[(int) (Math.random() * GameMode.values().length)]);
    }

    public static Game factorGameWithAnyAsDifficulty() {
        return factorGame(Category.values()[(int) (Math.random() * Difficulty.values().length)], Difficulty.ANY, GameMode.values()[(int) (Math.random() * GameMode.values().length)]);
    }

    public static Game factorRandomGame() {
        Difficulty difficulty = Difficulty.values()[(int) (Math.random() * Difficulty.values().length)];
        Category category = Category.values()[(int) (Math.random() * Category.values().length)];
        GameMode gameMode = GameMode.values()[(int) (Math.random() * GameMode.values().length)];
        return factorGame(category, difficulty, gameMode);
    }
}
