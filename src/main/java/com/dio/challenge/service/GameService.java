package com.dio.challenge.service;

import com.dio.challenge.common.GameType;
import com.dio.challenge.dataaccess.model.Game;

import java.util.HashSet;
import java.util.List;

public interface GameService {

    void addGame(GameType gameType, HashSet<Integer> numbers);

    List<Game> getAllGames();

    boolean checkGame(GameType gameType, HashSet<Integer> numbers);
}
