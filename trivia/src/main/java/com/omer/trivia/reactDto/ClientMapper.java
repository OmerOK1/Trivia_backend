package com.omer.trivia.reactDto;

import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientMapper {
    public static QuestionDto mapToQuestionDto(Question entity) {
        QuestionDto dto = new QuestionDto();
        dto.setQuestionBody(entity.getQuestionBody());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        dto.setGameId(entity.getId());
        dto.setOption1(entity.getOption1());
        dto.setOption2(entity.getOption2());
        dto.setOption3(entity.getOption3());
        dto.setOption4(entity.getOption4());
        return dto;
    }

    public static List<QuestionDto> mapToDtoList(List<Question> entities) {
        List<QuestionDto> dtoList = new ArrayList<>();
        for (Question question: entities) {
            dtoList.add(mapToQuestionDto(question));
        }
        return dtoList;
    }

    public static GameDto mapToGameDto(Game entity) {
        GameDto dto = new GameDto();
        dto.setId(entity.getId());
        dto.setCategory(entity.getCategory().name());
        dto.setDifficulty(entity.getDifficulty().name());
        dto.setLayout(entity.getLayout().name());
        dto.setUrl(entity.getUrl());
        dto.setTitle(entity.getTitle());
        dto.setAnswerTimeLimit(entity.getAnswerTimeLimit());
        dto.setQuestionsPerRound(entity.getQuestionsPerRound());
        dto.setQuestions(mapToDtoList(entity.getQuestions()));
        dto.setMultiplayer(entity.isMultiplayer());
        return dto;
    }
}
