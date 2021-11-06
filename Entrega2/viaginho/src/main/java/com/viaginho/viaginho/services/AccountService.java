package com.viaginho.viaginho.services;

import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.repositories.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService { // No esquema esse é o LoginControlador

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public boolean validateAccount(Account account) {
        Account account2 = accountRepository.findById(account.getEmail()).orElse(null);
        return account2 != null && account2.getPassword().equals(account.getPassword());
    }

    public Account getAccount(String email) {
        return accountRepository.findById(email).orElseThrow();
    }
}
