package com.dio.challenge.service;

import com.dio.challenge.common.AppUtil;
import com.dio.challenge.common.GameType;
import com.dio.challenge.dataaccess.model.Game;
import com.dio.challenge.dataaccess.repository.GameRepository;
import com.dio.challenge.exception.InvalidGameException;
import com.dio.challenge.exception.ThereIsAlreadyGameException;
import com.dio.challenge.service.base.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository repository;

    @Autowired
    public GameServiceImpl(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addGame(GameType gameType, HashSet<Integer> numbers) {
        if (numbers.size() != gameType.getMinimumQuantitySelected()) {
            throw new InvalidGameException("Quantidade de números informado é inválido para esse tipo de jogo!");
        }
        boolean outOfRange = numbers.stream().anyMatch(number -> (number == 0 || number > gameType.getPossibilities()));
        if (outOfRange) {
            throw new InvalidGameException("Os números deverão estar entre 1 e " + gameType.getPossibilities());
        }
        String orderedNumbers = AppUtil.numbersToString(numbers);
        if (!checkGame(gameType, numbers)) {
            Game game = new Game();
            game.setNumbers(orderedNumbers);
            game.setGameType(gameType);
            repository.save(game);
        } else {
            throw new ThereIsAlreadyGameException("Jogo já existente");
        }
    }

    public List<Game> getAllGames() {
        return repository.findAll();
    }

    @Override
    public boolean checkGame(GameType gameType, HashSet<Integer> numbers) {
        String orderedNumbers = AppUtil.numbersToString(numbers);
        Optional<Game> exist = repository.findGameByNumbersAndGameType(orderedNumbers, gameType);
        // TODO Retornar quais numeros foram acertados
        // Os acertos podem varias conforme o tipo do jogo: gameType.getVictoryWithMoreThan()
        // Ex.: Na mega podemos ganhar com 4, 5 ou 6 acertos
        return exist.isPresent();
    }


}
