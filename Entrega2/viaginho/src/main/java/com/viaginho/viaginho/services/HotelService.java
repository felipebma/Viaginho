package com.viaginho.viaginho.services;

import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.services.adapters.HotelAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelService {
    @Autowired HotelAdapter hotelAdapter;

    public void getHotels(HotelSearchData hotelSearchData) throws NoSuchAlgorithmException, JsonProcessingException {
        hotelAdapter.getHotels(hotelSearchData);
    }
}
