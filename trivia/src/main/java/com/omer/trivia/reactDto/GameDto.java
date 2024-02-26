package com.omer.trivia.reactDto;

import lombok.Data;

import java.util.List;
@Data
public class GameDto {
    private int id;
    private String title;
    private String category;
    private String difficulty;
    private int questionsPerRound;
    private int answerTimeLimit;
    private String layout;
    private String url;
    private String gameMode;
    private boolean isMultiplayer;
    private List<QuestionDto> questions;
}
