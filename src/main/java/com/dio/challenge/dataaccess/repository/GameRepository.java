package com.dio.challenge.dataaccess.repository;

import com.dio.challenge.common.GameType;
import com.dio.challenge.dataaccess.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findGameByNumbersAndGameType(String numbers, GameType gameType);
}
