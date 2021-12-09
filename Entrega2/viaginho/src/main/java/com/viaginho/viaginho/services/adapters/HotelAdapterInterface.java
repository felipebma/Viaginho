package com.viaginho.viaginho.services.adapters;

import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.ListHotel;

import org.springframework.stereotype.Component;

@Component
public interface HotelAdapterInterface {
    public ListHotel getHotels(HotelSearchData hotelSearchData)
            throws NoSuchAlgorithmException, JsonProcessingException;
}
