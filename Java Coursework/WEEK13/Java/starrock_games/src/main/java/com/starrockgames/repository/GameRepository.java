package com.starrockgames.repository;

import com.starrockgames.model.Game;

import java.util.List;

public interface GameRepository {
    List<Game> findAllGames();

    Game addGame(Game game);

    Long findNextGameId();

    Game findGameById(Long gameId);

    Game editGame(Long gameId, String gameName, String gamePrice);

    boolean deleteGameById(Long gameId);
}
