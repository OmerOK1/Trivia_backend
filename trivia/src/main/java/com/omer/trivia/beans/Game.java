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

    /*@Column(nullable = false)
    private MyUser host;*/
    @Column(nullable = false, name = "game_title")
    private String title;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "game_categories")
    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Set<Category> categories;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "game_difficulties")
    @Column(name = "difficulty")
    @Enumerated(EnumType.STRING)
    private Set<Difficulty> difficulties;
    @Column(nullable = false)
    private int questionsPerRound;
    @Column(nullable = false)
    private int answerTimeLimit;
    /*@Enumerated(EnumType.STRING)
    private Layout layout; //TODO: check if more annotations are needed*/
    @Column(nullable = false, name = "game_url")
    private String url; //TODO: string?

}

    /*@OneToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)//TODO: mappedBy = "x" not working
    private Set<MyUser> players;*/
    /*@OneToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    private List<Round> rounds;*/





//TODO: Game:
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


