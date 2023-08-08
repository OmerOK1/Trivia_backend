/*
package com.omer.trivia;

import com.omer.trivia.beans.Question;
import com.omer.trivia.beans.User;

import lombok.Data;

import java.sql.Timestamp;

@Data //TODO find how to encapsulate this, either @Entity or something else. Use other project as reference.
public class PlayerResponse {
    private User player;

    private Question question;

    private String answer; //initially conceived as string, int is smaller and can work with an ordered map instead of a hash. TODO: change the answers hashmap in Question to an ordered one. and this to int

    private Timestamp timestamp; // TODO: placeHolder, find time management api

}
//TODO: PlayerResponse:
// player: User
// question: Question
// –
// answerTimestamp : timestamp
// answer: string
// –
// isCorrect()
// getTimeToAnswer()
// getScore()*/
