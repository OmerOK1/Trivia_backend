package com.omer.trivia.beans;

import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import jakarta.persistence.*;
import lombok.*;

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


    /**
     * Mapping of possible answers to their correctness status.
     * Was previously a OneToMany relationship with another entity for Answer.
     * This is a little less obvious to use, but much more compact.
     */
    @ElementCollection
    @CollectionTable(name = "question_answers")
    @MapKeyColumn(name = "answer_body")
    @Column(name = "is_correct")
    private Map<String, Boolean> answersToCorrectness;

    @Column(nullable = false)
    private Category category; // Todo: only one? choose.

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

   /* @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator; //TODO separate 2 entities for created by player and from api
*/
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Round round;

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
