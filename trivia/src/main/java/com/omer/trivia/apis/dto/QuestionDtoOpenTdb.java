package com.omer.trivia.apis.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDtoOpenTdb {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;

    public final List<String> getOptions() {
        List<String> options = incorrect_answers;
        options.add((int)(Math.random()*4), correct_answer);
        return options;
    }
}

