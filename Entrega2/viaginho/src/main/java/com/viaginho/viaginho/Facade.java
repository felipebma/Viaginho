package com.viaginho.viaginho;

import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.model.Account;
import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.ListHotel;
import com.viaginho.viaginho.model.ListHotelReservation;
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
        return accountService.getAccountByEmail(account.getEmail());
    }

    public boolean accountExists(String email) {
        return accountService.getAccountByEmail(email) != null;
    }

    public ListHotel getHotels(HotelSearchData hotelSearchData)
            throws NoSuchAlgorithmException, JsonProcessingException {
        return hotelService.getHotels(hotelSearchData);
    }

    public ListHotelReservation getReservations(String userEmail) {
        return hotelService.getReservations(userEmail);
    }

    public HotelReservation createHotelReservation(HotelReservation hotelReservation) {
        return hotelService.createReservation(hotelReservation);
    }
}
