package com.omer.trivia.beans;

//import com.omer.trivia.PlayerResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

/*@Entity
@Table(name = "game_rounds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameRound {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    *//*@ManyToOne
    @JoinColumn(name = "round_id")*//*
    //private Round round; // TODO: consider keeping as a Unidirectional Relationship from this end (not having GameRounds property in Round), unless you find reasons to access GameRound from Round.

    @Column(nullable = false)
    private int currentQuestionIdx;*/

    //private HashMap<Question, Timestamp> presentTimes; // TODO: Figure out what are your needs and find the right timeStamp type. Fix - 'name unintuitive to use-case'. Find Annotations.

    //private List<PlayerResponse> playerResponses;}






