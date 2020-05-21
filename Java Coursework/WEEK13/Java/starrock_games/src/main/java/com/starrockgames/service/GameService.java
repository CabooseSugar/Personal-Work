package com.starrockgames.service;

import com.starrockgames.model.Game;

import java.util.List;

public interface GameService {
    List<Game> findAllGames();

    Game addGame(Game game);

    List<Game> findAllFilteredGames(String filter);

    Game findGameById(Long gameId);

    Game editGame(Long gameId, String gameName, String gamePrice);

    boolean deleteGameById(Long gameId);
}
