package com.starrockgames.bootstrap;

import com.starrockgames.model.Game;
import com.starrockgames.repository.GameRepository;
import com.starrockgames.repository.impl.GameRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private GameRepository gameRepository;

    public DatabaseLoader() {
//        this.gameRepository = new GameRepositoryImpl();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Game g1 = new Game(1L, "Red Dead Redemption 2", 59.99, 'M');
        this.gameRepository.addGame(g1);
        Game g2 = new Game(2L, "Assassin's Creed Odyssey", 59.99, 'M');
        this.gameRepository.addGame(g2);
        Game g3 = new Game(3L, "Shadow of the Tomb Raider", 59.99, 'M');
        this.gameRepository.addGame(g3);
        Game g4 = new Game(4L, "Call of Duty Black Ops 4", 59.99, 'M');
        this.gameRepository.addGame(g4);

    }
}
