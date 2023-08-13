package com.omer.trivia.beans;

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


    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Round round;*/

    @Column(nullable = false)
    private String sourceAPI;

}

