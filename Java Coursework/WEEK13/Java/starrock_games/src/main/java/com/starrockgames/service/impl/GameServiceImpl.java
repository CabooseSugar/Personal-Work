package com.starrockgames.service.impl;

import com.starrockgames.model.Game;
import com.starrockgames.repository.GameRepository;
import com.starrockgames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    public GameServiceImpl() {

//        this.gameRepository = new GameRepositoryImpl();
    }

    @Override
    public List<Game> findAllGames() {
        return gameRepository.findAllGames();
    }

    @Override
    public Game addGame(Game game) {

        if (game.getGameId() == null || game.getGameId() <= 0) {
            game.setGameId(gameRepository.findNextGameId());
        }
        return gameRepository.addGame(game);
    }

    @Override
    public List<Game> findAllFilteredGames(String filter) {
        List<Game> games = gameRepository.findAllGames();
        return games.stream()
                .filter(g -> g.getGameName().toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Game findGameById(Long gameId) {
        return gameRepository.findGameById(gameId);
    }

    @Override
    public Game editGame(Long gameId, String gameName, String gamePrice) {
        return gameRepository.editGame(gameId, gameName, gamePrice);
    }

    @Override
    public boolean deleteGameById(Long gameId) {
        return gameRepository.deleteGameById(gameId);
    }
}
