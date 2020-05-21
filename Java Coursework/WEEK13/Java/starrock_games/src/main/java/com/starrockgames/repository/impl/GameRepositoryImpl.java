package com.starrockgames.repository.impl;

import com.google.common.collect.MoreCollectors;
import com.starrockgames.model.Game;
import com.starrockgames.repository.GameRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepositoryImpl implements GameRepository {

    private List<Game> gameList = new ArrayList<>();

    @Override
    public List<Game> findAllGames() {
        return gameList;
    }

    @Override
    public Game addGame(Game game) {
        gameList.add(game);
        return game;
    }

    @Override
    public Long findNextGameId() {
        Long maxValue = 0L;
        for (Game game : gameList) {
            if (game.getGameId() != null && game.getGameId() > maxValue) {
                maxValue = game.getGameId();
            }
        }
        return maxValue + 1;
    }

    @Override
    public Game findGameById(Long gameId) {
//        for (Game g : gameList) {
//            if (g.getGameId() == gameId) {
//                return g;
//            }
//        }
//        return null;
        return gameList.stream().filter(g -> g.getGameId() == gameId).collect(MoreCollectors.onlyElement());
    }

    @Override
    public Game editGame(Long gameId, String gameName, String gamePrice) {
        Game foundGame = findGameById(gameId);
        if (foundGame != null) {
            foundGame.setGameName(gameName);
            foundGame.setPrice(Double.parseDouble(gamePrice));
        }
        return foundGame;
    }

    @Override
    public boolean deleteGameById(Long gameId) {
        Game foundGame = findGameById(gameId);
        if (foundGame != null) {
            return gameList.remove(foundGame);
        }
        return false;
    }
}
