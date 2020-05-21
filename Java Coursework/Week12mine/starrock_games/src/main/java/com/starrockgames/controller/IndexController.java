package com.starrockgames.controller;

import com.starrockgames.model.Game;
import com.starrockgames.service.GameService;
import com.starrockgames.service.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired // dependency injection
    private GameService gameService;

    public IndexController() {

//        this.gameService = new GameServiceImpl();
    }

    @GetMapping("/")
    public String index(Model model) {

        List<Game> gameList = this.gameService.findAllGames();
        model.addAttribute("games", gameList);
        //model.addAttribute("showTable", Boolean.TRUE);
        return "index"; // index.html, that is
    }

}
