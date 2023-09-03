package com.omer.trivia.apis.dto;

import com.omer.trivia.beans.Question;
import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class QuestionMapper {
    public static Question mapOneFromDto(QuestionDto dto) {
        List<String> options = dto.getOptions();

        return Question.builder()
                .option1(options.get(0))
                .option2(options.get(1))
                .option3(options.get(2))
                .option4(options.get(3))
                .category(Category.valueOf(dto.getCategory()))
                .difficulty(Difficulty.valueOf(dto.getDifficulty()))
                .questionBody(dto.getQuestion())
                .correctAnswer(dto.getCorrect_answer())
                .sourceAPI("Open Trivia Database")
                .build();
    }

    public static List<Question> mapManyFromDto(List<QuestionDto> dtoList) {
        List<Question> questions = new ArrayList<>();
        for (QuestionDto dto: dtoList) {
            questions.add(mapOneFromDto(dto));
        }
        return questions;
    }

}
