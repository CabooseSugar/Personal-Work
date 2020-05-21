package com.starrockgames.service;

import com.starrockgames.model.Game;
import java.util.List;

public interface GameService {
    List<Game> findAllGames();
}
