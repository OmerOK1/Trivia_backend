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
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "round_categories")
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Set<Category> categories;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "round_difficulties")
    @Column(name = "difficulty")
    @Enumerated(EnumType.STRING)
    private Set<Difficulty> difficulties;

    @Column(nullable = false)
    private int questionsPerRound;
    @Column(nullable = false)
    private int answerTimeLimit;


    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "round", fetch = FetchType.LAZY) //TODO: add needed annotations
    private List<Question> questionList;


    /*private User Creator; // TODO*/



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