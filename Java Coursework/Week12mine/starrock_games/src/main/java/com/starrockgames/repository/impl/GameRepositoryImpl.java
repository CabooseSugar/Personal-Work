package com.starrockgames.repository.impl;

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
}
