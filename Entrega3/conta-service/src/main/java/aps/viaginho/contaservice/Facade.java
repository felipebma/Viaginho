package aps.viaginho.contaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.contaservice.model.Account;
import aps.viaginho.contaservice.services.AccountService;

@Component
public class Facade {

    @Autowired
    private AccountService accountService;

    public Account createAccount(Account account) {
        return accountService.createAccount(account);
    }

    public Account login(Account account) {
        if (!accountService.validateAccount(account)) {
            return null;
        }
        return accountService.getAccountByEmail(account.getEmail());
    }

    public boolean accountExists(String email) {
        return accountService.getAccountByEmail(email) != null;
    }

}
