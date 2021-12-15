package aps.viaginho.contaservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aps.viaginho.contaservice.collections.AccountCollection;
import aps.viaginho.contaservice.model.Account;

@Service
public class AccountService {

    @Autowired
    private AccountCollection accountCollection;

    public Account login(Account account) {
        if (!validateAccount(account)) {
            return null;
        }
        return getAccountByEmail(account.getEmail());
    }

    public Account createAccount(Account account) {
        return accountCollection.save(account);
    }

    public boolean validateAccount(Account account) {
        Account account2 = accountCollection.findById(account.getEmail());
        return account2 != null && account2.getPassword().equals(account.getPassword());
    }

    public Account getAccountByEmail(String email) {
        System.out.println(email);
        return accountCollection.findById(email);
    }

}
