package com.omer.trivia.repository;

import com.omer.trivia.beans.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAllByGameId(int gameId);

}
