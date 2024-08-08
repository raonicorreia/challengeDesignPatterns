package com.dio.challenge.controller;

import com.dio.challenge.common.GameType;
import com.dio.challenge.dataaccess.model.Game;
import com.dio.challenge.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public void addGame(@RequestParam(name = "gameType") GameType gameType,
                        @RequestBody HashSet<Integer> numbers) {
        gameService.addGame(gameType, numbers);
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.of(Optional.ofNullable(gameService.getAllGames()));
    }

    @PostMapping("/check")
    public ResponseEntity<Boolean> check(@RequestParam(name = "gameType") GameType gameType,
                                            @RequestBody HashSet<Integer> numbers) {
        return ResponseEntity.of(Optional.ofNullable(gameService.checkGame(gameType, numbers)));
    }
}
