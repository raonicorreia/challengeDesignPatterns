package com.dio.challenge;

import com.dio.challenge.common.AppUtil;
import com.dio.challenge.common.GameType;
import com.dio.challenge.dataaccess.model.Game;
import com.dio.challenge.dataaccess.repository.GameRepository;
import com.dio.challenge.exception.BusinessException;
import com.dio.challenge.exception.InvalidGameException;
import com.dio.challenge.exception.ThereIsAlreadyGameException;
import com.dio.challenge.service.GameServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.aot.generate.Generated;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class DesignPatternsApplicationTests {

    @InjectMocks
    private GameServiceImpl gameService;

    @Mock
    private GameRepository repository;

    @Test
    void adicionarNovoJogo() {
        HashSet<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        gameService.addGame(GameType.MEGA_SENA, numbers);
        Assertions.assertTrue(true);
    }

    @Test
    void quantidadeDeNumerosInvalido() {
        HashSet<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Assertions.assertThrows(BusinessException.class, () -> {
            gameService.addGame(GameType.MEGA_SENA, numbers);
        });
    }

    @Test
    void foraDoRange() {
        Assertions.assertThrows(InvalidGameException.class, () -> {
            gameService.addGame(GameType.MEGA_SENA, new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 0)));
        });

        Assertions.assertThrows(InvalidGameException.class, () -> {
            gameService.addGame(GameType.MEGA_SENA, new HashSet<>(Arrays.asList(100, 2, 3, 4, 5, 50)));
        });

        Assertions.assertThrows(InvalidGameException.class, () -> {
            gameService.addGame(GameType.LOTO_FACIL, new HashSet<>(Arrays.asList(1000, 2, 3, 4, 5, 50, 7, 8, 9, 10, 11, 12, 13, 14, 15)));
        });
    }

    @Test
    void adicionandoMesmoJogo() {
        GameType gameType = GameType.MEGA_SENA;
        HashSet<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Game game = createNewGame(gameType, numbers);
        Mockito.when(repository.findGameByNumbersAndGameType(AppUtil.numbersToString(numbers), gameType)).thenReturn(Optional.of(game));
        Assertions.assertThrows(ThereIsAlreadyGameException.class, () -> {
            gameService.addGame(gameType, numbers);
            gameService.addGame(gameType, numbers);
        });
    }

    @Test
    void listandoTodosJogos() {
        List<Game> games = new ArrayList();
        games.add(createNewGame(GameType.MEGA_SENA, new HashSet<>(Arrays.asList(1, 2, 3, 4, 53, 6))));
        games.add(createNewGame(GameType.MEGA_SENA, new HashSet<>(Arrays.asList(7, 9, 3, 46, 5, 6))));
        games.add(createNewGame(GameType.MEGA_SENA, new HashSet<>(Arrays.asList(18, 20, 3, 4, 5, 6))));
        games.add(createNewGame(GameType.MEGA_SENA, new HashSet<>(Arrays.asList(15, 29, 35, 47, 5, 6))));
        games.add(createNewGame(GameType.MEGA_SENA, new HashSet<>(Arrays.asList(18, 23, 39, 4, 5, 6))));
        Mockito.when(repository.findAll()).thenReturn(games);
        List<Game> result = gameService.getAllGames();

        Assertions.assertEquals(games.size(), result.size());
    }

    private Game createNewGame(GameType gameType, HashSet<Integer> numbers) {
        Game game = new Game();
        game.setGameType(gameType);
        game.setNumbers(AppUtil.numbersToString(numbers));
        game.setId(1L);
        return game;
    }
}
