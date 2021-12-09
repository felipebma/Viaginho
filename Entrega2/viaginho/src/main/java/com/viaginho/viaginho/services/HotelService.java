package com.viaginho.viaginho.services;

import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.ListHotel;
import com.viaginho.viaginho.model.ListHotelReservation;
import com.viaginho.viaginho.repositories.HotelReservationRepository;
import com.viaginho.viaginho.services.adapters.HotelAdapterInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelService {
    @Autowired
    HotelAdapterInterface hotelAdapter;
    @Autowired
    HotelReservationRepository hotelReservationRepository;

    public HotelReservation createReservation(HotelReservation hotelReservation) {
        return hotelReservationRepository.save(hotelReservation);
    }

    public ListHotelReservation getReservations(String userEmail) {
        return new ListHotelReservation(hotelReservationRepository.findAllByUserEmail(userEmail));
    }

    public ListHotel getHotels(HotelSearchData hotelSearchData)
            throws NoSuchAlgorithmException, JsonProcessingException {
        return hotelAdapter.getHotels(hotelSearchData);
    }
}
