package com.viaginho.viaginho;

import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Facade {
    @Autowired AccountService accountService;

    public Account login(Account account) {
        if(!accountService.validateAccount(account)){
            return null;
        }
        return accountService.getAccount(account.getEmail());
    }

    
}
