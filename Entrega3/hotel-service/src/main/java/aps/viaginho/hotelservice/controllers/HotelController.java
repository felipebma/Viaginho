package aps.viaginho.hotelservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aps.viaginho.hotelservice.Facade;
import aps.viaginho.hotelservice.model.HotelReservation;
import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;

@RestController
public class HotelController {

    @Autowired
    private Facade facade;

    @PostMapping
    public List<Hotel> getHotels(@RequestBody HotelSearchData hotelSearchData) {
        return facade.getHotels(hotelSearchData);
    }

    @GetMapping("reservations")
    public List<HotelReservation> getReservations(@RequestParam String userEmail) {
        System.out.println(userEmail);
        return facade.getReservations(userEmail);
    }

    @PostMapping("reservations")
    public HotelReservation createReservation(@RequestBody HotelReservation hotelReservation) {
        return facade.createHotelReservation(hotelReservation);
    }

}
