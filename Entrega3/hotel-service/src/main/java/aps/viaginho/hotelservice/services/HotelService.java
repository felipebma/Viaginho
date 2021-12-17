package aps.viaginho.hotelservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.hotelservice.collections.HotelReservationCollection;
import aps.viaginho.hotelservice.model.HotelReservation;
import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;
import aps.viaginho.hotelservice.services.adapters.HotelAdapter;

@Component
public class HotelService {
    @Autowired
    HotelAdapter hotelAdapter;
    @Autowired
    HotelReservationCollection hotelReservationCollection;

    public HotelReservation createReservation(HotelReservation hotelReservation) {
        return hotelReservationCollection.save(hotelReservation);
    }

    public List<HotelReservation> getReservations(String userEmail) {
        return hotelReservationCollection.findAllByUserEmail(userEmail);
    }

    public List<Hotel> getHotels(HotelSearchData hotelSearchData) {
        return hotelAdapter.getHotels(hotelSearchData);
    }
}
