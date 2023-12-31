package com.omer.trivia.repository;

import com.omer.trivia.beans.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
