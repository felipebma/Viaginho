package aps.viaginho.contaservice.collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.contaservice.model.Account;
import aps.viaginho.contaservice.repositories.AccountRepository;

@Component
public class AccountCollection {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account findById(String email) {
        return accountRepository.findById(email).orElse(null);
    }

}
