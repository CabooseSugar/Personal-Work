package com.starrockgames.bootstrap;

import com.starrockgames.model.ApplicationUser;
import com.starrockgames.model.Game;
import com.starrockgames.repository.ApplicationUserRepository;
import com.starrockgames.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    public DatabaseLoader() {
//        this.gameRepository = new GameRepositoryImpl();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        /*
            Load the games!
         */
        Game g1 = new Game(1L, "Red Dead Redemption 2", 59.99, 'M');
        this.gameRepository.addGame(g1);
        Game g2 = new Game(2L, "Assassin's Creed Odyssey", 59.99, 'M');
        this.gameRepository.addGame(g2);
        Game g3 = new Game(3L, "Shadow of the Tomb Raider", 59.99, 'M');
        this.gameRepository.addGame(g3);
        Game g4 = new Game(4L, "Call of Duty Black Ops 4", 59.99, 'M');
        this.gameRepository.addGame(g4);

        /*
            Make some users
         */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        ApplicationUser user1 = new ApplicationUser("admin", encoder.encode("secretpassword"), Boolean.TRUE);
        applicationUserRepository.addUser(user1);
        ApplicationUser user2 = new ApplicationUser("fred", encoder.encode("12345"), Boolean.FALSE);
        applicationUserRepository.addUser(user2);

    }
}
