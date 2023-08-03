package com.omer.trivia.beans;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 30)
    private String id;
}
/*TODO: User:
        Id : string
        email : string
        phoneNumber : string
        name : string
        country: string
        –
        source: enum(internal, google)
        –
        getCustomRounds()
        getCustomerQuestions()
        getHostedGames()
        getPlayedGames()
        getStatistics()*/
