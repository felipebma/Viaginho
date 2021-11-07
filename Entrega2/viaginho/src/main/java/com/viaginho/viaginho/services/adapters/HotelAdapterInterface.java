package com.viaginho.viaginho.services.adapters;

import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.HotelSearchResponse.Hotel;

import org.springframework.stereotype.Component;

@Component
public interface HotelAdapterInterface {
    public List<Hotel> getHotels(HotelSearchData hotelSearchData) throws NoSuchAlgorithmException, JsonProcessingException;
}
