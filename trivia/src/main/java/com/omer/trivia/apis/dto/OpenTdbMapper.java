package com.omer.trivia.apis.dto;

import com.omer.trivia.beans.Question;
import com.omer.trivia.beans.enums.Difficulty;
import org.apache.commons.text.StringEscapeUtils;


import java.util.ArrayList;
import java.util.List;

public class OpenTdbMapper {
    public static Question mapOneFromDto(QuestionDtoOpenTdb dto) {
        List<String> options = dto.getOptions();

        return Question.builder()
                .option1(decode(options.get(0)))
                .option2(decode(options.get(1)))
                .option3(decode(options.get(2)))
                .option4(decode(options.get(3)))
                .questionBody(decode(dto.getQuestion()))
                .correctAnswer(decode(dto.getCorrect_answer()))
                .difficulty(Difficulty.valueOf(dto.getDifficulty()))
                .build();
    }

    private static String decode(String encoded) {
        return StringEscapeUtils.unescapeHtml4(encoded);
    }

    public static List<Question> mapManyFromDto(List<QuestionDtoOpenTdb> dtoList) {
        List<Question> questions = new ArrayList<>();
        for (QuestionDtoOpenTdb dto: dtoList) {
            questions.add(mapOneFromDto(dto));
        }
        return questions;
    }

}
