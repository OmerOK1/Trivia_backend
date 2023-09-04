package com.omer.trivia.apis;
import com.omer.trivia.apis.dto.QuestionDtoOpenTdb;
import lombok.Data;

import java.util.List;

@Data
public class OpenTdbResponse {
    private List<QuestionDtoOpenTdb> results;
}
