package com.omer.trivia.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String questionBody;
    @Column(nullable = false)

    private String option1;
    @Column(nullable = false)

    private String option2;
    @Column(nullable = false)

    private String option3;
    @Column(nullable = false)

    private String option4;
    @Column(nullable = false)

    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    @Column(nullable = false)
    private String sourceAPI;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;

}

