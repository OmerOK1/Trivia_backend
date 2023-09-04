package com.omer.trivia.reactDto;

import lombok.Data;

@Data
public class QuestionDto {
    private String questionBody;
    private String correctAnswer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int gameId;
}
