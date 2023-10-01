package com.omer.trivia.controllers;

import com.omer.trivia.beans.Game;
import com.omer.trivia.reactDto.GameDto;
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
        return this.customerService.addGame(game);
    }

    @PostMapping({"games/getone"})
    @ResponseStatus(HttpStatus.OK)
    public GameDto getCoupon(@RequestBody int id) throws Exception {
        return this.customerService.getGame(id);
    }

}

