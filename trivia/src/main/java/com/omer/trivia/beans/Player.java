package com.omer.trivia.beans;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    @ManyToOne( cascade = {CascadeType.ALL})
    @JoinColumn(name = "game_id")
    @ToString.Exclude
    private Game game;
    @Column
    private String name;
    @Column
    private boolean host;
}

