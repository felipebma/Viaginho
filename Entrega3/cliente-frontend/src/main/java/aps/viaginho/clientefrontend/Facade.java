package aps.viaginho.clientefrontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.clientefrontend.model.Account;
import aps.viaginho.clientefrontend.model.HotelDTO;
import aps.viaginho.clientefrontend.model.HotelReservation;
import aps.viaginho.clientefrontend.model.HotelSearchData;
import aps.viaginho.clientefrontend.services.AccountService;
import aps.viaginho.clientefrontend.services.HotelService;

@Component
public class Facade {

    @Autowired
    private AccountService accountService;

    @Autowired
    private HotelService hotelService;

    public Account createAccount(Account account) {
        return accountService.createAccount(account);
    }

    public Account login(Account account) {
        return accountService.login(account);
    }

    public List<HotelDTO> getHotels(HotelSearchData hotelSearchData) {
        return hotelService.getHotels(hotelSearchData);
    }

    public List<HotelReservation> getReservations(String userEmail) {
        return hotelService.getReservations(userEmail);
    }

    public HotelReservation createHotelReservation(HotelReservation hotelReservation) {
        return hotelService.createReservation(hotelReservation);
    }

}
