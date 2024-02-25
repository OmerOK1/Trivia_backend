package com.omer.trivia.reactDto;

import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.Question;
import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import com.omer.trivia.beans.enums.Layout;

import java.util.ArrayList;
import java.util.List;

public class ClientMapper {
    public static QuestionDto mapQuestionToDto(Question entity) {
        QuestionDto res = new QuestionDto();
        res.setQuestionBody(entity.getQuestionBody());
        res.setCorrectAnswer(entity.getCorrectAnswer());
        res.setGameId(entity.getId());
        res.setOption1(entity.getOption1());
        res.setOption2(entity.getOption2());
        res.setOption3(entity.getOption3());
        res.setOption4(entity.getOption4());
        return res;
    }

    public static List<QuestionDto> mapToDtoList(List<Question> entities) {
        List<QuestionDto> res = new ArrayList<>();
        for (Question question: entities) {
            res.add(mapQuestionToDto(question));
        }
        return res;
    }

    public static GameDto mapGameToDto(Game entity) {
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

    public static Question mapDtoToQuestion(QuestionDto entity) {
        Question res = new Question();
        res.setQuestionBody(entity.getQuestionBody());
        res.setCorrectAnswer(entity.getCorrectAnswer());
        res.setId(entity.getGameId());
        res.setOption1(entity.getOption1());
        res.setOption2(entity.getOption2());
        res.setOption3(entity.getOption3());
        res.setOption4(entity.getOption4());
        return res;
    }

    public static List<Question> mapDtoToQuestionList(List<QuestionDto> entities) {
        List<Question> res = new ArrayList<>();
        for (QuestionDto entity: entities) {
            res.add(mapDtoToQuestion(entity));
        }
        return res;
    }

    public static Game mapDtoToGame(GameDto entity) {
        return Game.builder()
                .id(entity.getId())
                .category(Category.valueOf(entity.getCategory()))
                .difficulty(Difficulty.valueOf(entity.getDifficulty()))
                .layout(Layout.valueOf(entity.getLayout()))
                .url(entity.getUrl())
                .title(entity.getTitle())
                .answerTimeLimit(entity.getAnswerTimeLimit())
                .questionsPerRound(entity.getQuestionsPerRound())
                .isMultiplayer(entity.isMultiplayer())
                .build();
    }
}
