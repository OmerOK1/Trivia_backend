package com.omer.trivia.beans;

import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import com.omer.trivia.beans.enums.Layout;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "games")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "game_title")
    private String title;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
    private Difficulty difficulty;
    @Column(nullable = false)
    private int questionsPerRound;
    @Column(nullable = true)
    private int answerTimeLimit;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // change nullable to false if needed. design wise it's best to only create if changed from default
    private Layout layout;
    @Column(nullable = false, name = "game_url")
    private String url;

}

    /*@OneToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)//
    private Set<MyUser> players;*/
    /*@OneToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    private List<Round> rounds;*/





//Game:
//        factorDiffculty: Enum(High, Medium Low) ??
//        factorTime: Enum(High, Medium Low) ??
//        –
//        addPredefinedRound(Round)
//        generateRound()
//        removeRoundByIndex(index)
//        removeRoundById(roundId)
//        –
//        createGameURL()
//        emailURL(emails: List)
//        smsURL(phoneNumbers: List)
//        –
//        addPlayer(User)
//        removePlayer(User)
//        –
//        startGame (??? What tasks happen here ???)
//        startNextRound()
//        –
//        getGameUserScores(player)
//        getGameScores()
//        –
//        hasMoreRounds()


