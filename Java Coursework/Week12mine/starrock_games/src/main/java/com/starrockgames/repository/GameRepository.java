package com.starrockgames.repository;

import com.starrockgames.model.Game;

import java.util.List;

public interface GameRepository {
    List<Game> findAllGames();

    Game addGame(Game game);
}
