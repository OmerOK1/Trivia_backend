package com.omer.trivia.beans;

import com.omer.trivia.beans.enums.Category;
import com.omer.trivia.beans.enums.Difficulty;
import com.omer.trivia.beans.enums.Layout;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "games")
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 30)
    private String id;
    @Column(nullable = false)
    private User host;
    @Column(nullable = false)
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
    @Enumerated(EnumType.STRING)
    private Layout layout; //TODO: check if more annotations are needed
    @Column(nullable = false)
    private String url; //TODO: string?
    @OneToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)//TODO: mappedBy = "x" not working
    private Set<User> players;
    @OneToMany(cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY)
    private List<Round> rounds;





    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


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


