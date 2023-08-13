package com.omer.trivia.beans;

import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "rounds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category; // TODO(low priority): consider making a list of categories instead of 1.


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(nullable = false)
    private int questionsPerRound;
    @Column(nullable = false)
    private int answerTimeLimit;


    /*@ToString.Exclude
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "round", fetch = FetchType.LAZY)
    private List<Question> questionList;*/


    /*private User Creator; */



}
//TODO:
//  factorDiffculty: Enum(High, Medium Low)
//  factorTime: Enum(High, Medium Low)
//  creator : Optional User
//  –
//  –
//  addQuestion(Question)
//  removeQuestion(Question)
//  generateQuestions()