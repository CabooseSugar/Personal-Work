package com.starrockgames.service.impl;

import com.starrockgames.model.Game;
import com.starrockgames.repository.GameRepository;
import com.starrockgames.repository.impl.GameRepositoryImpl;
import com.starrockgames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
