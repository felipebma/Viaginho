package aps.viaginho.clientefrontend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aps.viaginho.clientefrontend.model.Account;
import aps.viaginho.clientefrontend.services.proxies.AccountServiceProxy;

@Service
public class AccountService {

    @Autowired
    AccountServiceProxy proxy;

    public Account createAccount(Account account) {
        return proxy.createAccount(account);
    }

    public Account login(Account account) {
        return proxy.login(account);
    }

}
