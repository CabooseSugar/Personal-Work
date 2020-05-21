package com.starrockgames.controller;

import com.starrockgames.model.Game;
import com.starrockgames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private GameService gameService;

    public IndexController() {

//        this.gameService = new GameServiceImpl();
    }

    /*
        VIEW DATABASE
     */

    @GetMapping("/")
    public String index(Model model) {

        List<Game> gameList = this.gameService.findAllGames();
        model.addAttribute("games", gameList);
//        model.addAttribute("showTable", Boolean.FALSE);
        return "index";
    }

    @PostMapping("/")
    public String searchGames(Model model, @RequestParam("filter") String filter) {

        model.addAttribute("games", gameService.findAllFilteredGames(filter));
        return "index";
    }

    /*
        ADD GAME
     */

    @GetMapping("/game/add")
    public String addGamePage(Model model ) {
        return "addgame";
    }

    @PostMapping("/game/add")
    public String addGameFormSubmit(Model model, @RequestParam("gameName") String gameName
            , @RequestParam("gamePrice") String gamePrice) {

        Double gamePriceDouble = 0.0;
        if (gameName == null || gameName.isEmpty()) {
            model.addAttribute("errorMessage", "Game Name is required");
            return "addgame";
        } else if (gamePrice != null) {
            try {
                gamePriceDouble = Double.valueOf(gamePrice);
            }catch (NumberFormatException nfex) {
                model.addAttribute("errorMessage", "Invalid game price");
                return "addgame";
            }
        }

        Game game = new Game(gameName, gamePriceDouble, 'M');
        game = gameService.addGame(game);
        model.addAttribute("success", Boolean.TRUE);
//        return "addgame";

        return "redirect:/";
    }

    /*
        EDIT GAME
     */
    @GetMapping(value = "/games/edit/{gameId}")
    public String editGameForm(@PathVariable Long gameId, Model model) {

        Game game = gameService.findGameById(gameId);
        if (game != null) {
            model.addAttribute("gameName", game.getGameName());
            model.addAttribute("gamePrice", game.getPrice());
            model.addAttribute("gameId", game.getGameId());
            return "edit";
        } else {
            return "index";
        }
    }

    @PostMapping(value = "/games/edit")
    public String saveGameEdit(@RequestParam(value = "gameName") String gameName, @RequestParam(value = "gamePrice") String gamePrice, @RequestParam(value = "gameId") Long gameId) {
        gameService.editGame(gameId, gameName, gamePrice);
        return "redirect:/";
    }

    /*
        DELETE GAME
     */

    @GetMapping(value = "/games/delete/{gameId}")
    public String deleteGame(@PathVariable Long gameId) {
        gameService.deleteGameById(gameId);
        return "redirect:/";
    }

}
