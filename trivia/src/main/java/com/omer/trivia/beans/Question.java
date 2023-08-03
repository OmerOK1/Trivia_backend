package com.omer.trivia.beans;

import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;

@Entity
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 30)
    private String id;
    @Column(nullable = false)
    private String questionBody;


    /**
     * Mapping of possible answers to their correctness status.
     * Was previously a OneToMany relationship with another entity for Answer.
     * This is a little less obvious to use, but much more compact.
     */
    @ElementCollection
    @CollectionTable(name = "question_answers")
    @MapKeyColumn(name = "answer_body")
    @Column(name = "is_correct")
    private HashMap<String, Boolean> answersToCorrectness;

    @Column(nullable = false)
    private Category category; // Todo: only one? choose.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @Column(nullable = false)
    private String sourceAPI;//TODO: enum? could be useful to track in some cases

}

//TODO: Question:
// id : string
// questionText : string
// –
// possibleAnswers : map<String, boolean>
// –
// category : Category
// difficulty : Difficulty
// –
// creator: User
// sourceAPI: String
// –
// checkAnswer(answer) -> bool
