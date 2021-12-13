package aps.viaginho.contaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aps.viaginho.contaservice.Facade;
import aps.viaginho.contaservice.model.Account;

@RestController
public class AccountController {

    @Autowired
    private Facade facade;

    @PostMapping
    public Account login(@RequestBody Account account) {
        return facade.login(account);
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        return facade.createAccount(account);
    }

}
