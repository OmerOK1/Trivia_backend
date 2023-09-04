package com.omer.trivia.apis.dto;

import com.omer.trivia.beans.Question;

import java.util.ArrayList;
import java.util.List;

public class OpenTdbMapper {
    public static Question mapOneFromDto(QuestionDtoOpenTdb dto) {
        List<String> options = dto.getOptions();

        return Question.builder()
                .option1(options.get(0))
                .option2(options.get(1))
                .option3(options.get(2))
                .option4(options.get(3))
                .questionBody(dto.getQuestion())
                .correctAnswer(dto.getCorrect_answer())
                .build();
    }

    public static List<Question> mapManyFromDto(List<QuestionDtoOpenTdb> dtoList) {
        List<Question> questions = new ArrayList<>();
        for (QuestionDtoOpenTdb dto: dtoList) {
            questions.add(mapOneFromDto(dto));
        }
        return questions;
    }

}
