package com.omer.trivia.beans;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne( cascade = {CascadeType.ALL})
    @JoinColumn(name = "game_id")
    @ToString.Exclude
    private Game game;
    @Column
    private String name;
    @Column
    private boolean host;
}

