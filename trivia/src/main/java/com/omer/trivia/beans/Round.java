package com.omer.trivia.beans;

import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "rounds")
@Data
public class Round {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 30)
    private String id;
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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = {CascadeType.ALL}) //TODO: mappedBy causes problems, add needed annotations
    private List<Question> questions;

    @Column
    private Optional<User> Creator;



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