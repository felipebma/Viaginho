package com.viaginho.viaginho.services;

import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.services.adapters.HotelAdapter;
import java.util.List;

import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.repositories.HotelReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelService {
    @Autowired HotelAdapter hotelAdapter;
    @Autowired
    HotelReservationRepository hotelReservationRepository;

    public List<HotelReservation> getReservations(String userEmail) {
        return hotelReservationRepository.findAllByUserEmail(userEmail);
    }

    public void getHotels(HotelSearchData hotelSearchData) throws NoSuchAlgorithmException, JsonProcessingException {
        hotelAdapter.getHotels(hotelSearchData);
    }
}
