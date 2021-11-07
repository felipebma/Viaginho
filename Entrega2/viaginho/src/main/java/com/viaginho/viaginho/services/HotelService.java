package com.viaginho.viaginho.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.HotelSearchResponse.Hotel;
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

    public List<HotelReservation> getReservations(String userEmail) {
        return hotelReservationRepository.findAllByUserEmail(userEmail);
    }

    public List<Hotel> getHotels(HotelSearchData hotelSearchData)
            throws NoSuchAlgorithmException, JsonProcessingException {
        return hotelAdapter.getHotels(hotelSearchData);
    }
}
