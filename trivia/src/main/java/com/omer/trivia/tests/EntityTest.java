package com.omer.trivia.tests;

import com.omer.trivia.repository.QuestionRepository;
import org.springframework.boot.CommandLineRunner;

public class EntityTest implements CommandLineRunner {

    protected final QuestionRepository questionRepository;

    public EntityTest(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
