package aps.viaginho.contaservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aps.viaginho.contaservice.model.Account;
import aps.viaginho.contaservice.repositories.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public boolean validateAccount(Account account) {
        Account account2 = accountRepository.findById(account.getEmail()).orElse(null);
        return account2 != null && account2.getPassword().equals(account.getPassword());
    }

    public Account getAccountByEmail(String email) {
        return accountRepository.findById(email).orElse(null);
    }

}
