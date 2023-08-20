package com.omer.trivia.apis;

import lombok.Data;

import java.util.List;

@Data
public class TriviaResult {
    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String correct_answer;
    private List<String> incorrect_answers;

    // Additional methods if needed, such as getting all options (correct + incorrect answers)
    public List<String> getOptions() {
        List<String> options = incorrect_answers;
        options.add(correct_answer);
        return options;
    }
}
