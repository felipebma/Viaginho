package aps.viaginho.hotelservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.hotelservice.model.HotelReservation;
import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;
import aps.viaginho.hotelservice.repositories.HotelReservationRepository;
import aps.viaginho.hotelservice.services.adapters.HotelAdapterInterface;

@Component
public class HotelService {
    @Autowired
    HotelAdapterInterface hotelAdapter;
    @Autowired
    HotelReservationRepository hotelReservationRepository;

    public HotelReservation createReservation(HotelReservation hotelReservation) {
        return hotelReservationRepository.save(hotelReservation);
    }

    public List<HotelReservation> getReservations(String userEmail) {
        return hotelReservationRepository.findAllByUserEmail(userEmail);
    }

    public List<Hotel> getHotels(HotelSearchData hotelSearchData) {
        return hotelAdapter.getHotels(hotelSearchData);
    }
}
