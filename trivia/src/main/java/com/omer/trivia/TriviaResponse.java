package com.omer.trivia;
import lombok.Data;

import java.util.List;

@Data
public class TriviaResponse {
    private List<TriviaResult> results;
}
