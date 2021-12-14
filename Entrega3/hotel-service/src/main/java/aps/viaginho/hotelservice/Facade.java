package aps.viaginho.hotelservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.hotelservice.model.HotelReservation;
import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;
import aps.viaginho.hotelservice.services.HotelService;

@Component
public class Facade {

    @Autowired
    private HotelService hotelService;

    public List<Hotel> getHotels(HotelSearchData hotelSearchData) {
        return hotelService.getHotels(hotelSearchData);
    }

    public List<HotelReservation> getReservations(String userEmail) {
        return hotelService.getReservations(userEmail);
    }

    public HotelReservation createHotelReservation(HotelReservation hotelReservation) {
        return hotelService.createReservation(hotelReservation);
    }

}
