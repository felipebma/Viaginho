package com.viaginho.viaginho;

import java.util.List;

import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.services.AccountService;
import com.viaginho.viaginho.services.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Facade {
    @Autowired
    AccountService accountService;
    @Autowired
    HotelService hotelService;

    public Account login(Account account) {
        if (!accountService.validateAccount(account)) {
            return null;
        }
        return accountService.getAccount(account.getEmail());
    }

    public List<HotelReservation> getReservations(String userEmail) {
        return hotelService.getReservations(userEmail);
    }

}
