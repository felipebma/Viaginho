package aps.viaginho.clientefrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.clientefrontend.model.Account;
import aps.viaginho.clientefrontend.services.AccountService;

@Component
public class Facade {

    @Autowired
    private AccountService accountService;

    public Account createAccount(Account account) {
        return accountService.createAccount(account);
    }

    public Account login(Account account) {
        return accountService.login(account);
    }

}
