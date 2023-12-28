package com.omer.trivia.controllers;

import com.omer.trivia.beans.Game;
import com.omer.trivia.beans.Player;
import com.omer.trivia.reactDto.GameDto;
import com.omer.trivia.reactDto.JoinGameStruct;
import com.omer.trivia.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(
        origins = {"*"},
        allowedHeaders = {"*"}
)
@RequestMapping({"customers/"})
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping({"games"})
    @ResponseStatus(HttpStatus.CREATED)
    public GameDto addGame(@RequestBody Game game) throws Exception {
        System.out.println("customerController addGame() reached");
        return this.customerService.addGame(game);
    }

    @PutMapping({"games/update"})
    @ResponseStatus(HttpStatus.CREATED)
    public Player updatePlayer(@RequestBody Player player, @RequestParam int gameId) throws Exception {
        System.err.println("arrived at update player (controller)");
        return this.customerService.updatePlayer(player, gameId);
    }

    @GetMapping({"games/join"})
    @ResponseStatus(HttpStatus.OK)
    public JoinGameStruct addPlayerToGame(@RequestParam int gameId) throws Exception {
        System.out.println("customerController addPlayerToGame() reached");
        return this.customerService.addPlayerToGame(gameId);
    }
    //    @GetMapping({"games/get"})
//    @ResponseStatus(HttpStatus.OK)
//    public GameDto getGame(@RequestParam int id) throws Exception {
//        return this.customerService.getGame(id);
//    }

}

