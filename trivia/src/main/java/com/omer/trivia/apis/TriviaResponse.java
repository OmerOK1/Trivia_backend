package com.omer.trivia.apis;
import com.omer.trivia.apis.dto.QuestionDto;
import lombok.Data;

import java.util.List;

@Data
public class TriviaResponse {
    //private List<TriviaResult> results;
    private List<QuestionDto> results;
}
