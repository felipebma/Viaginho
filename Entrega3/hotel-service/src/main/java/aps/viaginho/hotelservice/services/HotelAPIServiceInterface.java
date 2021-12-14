package aps.viaginho.hotelservice.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.stereotype.Component;

import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;

@Component
public interface HotelAPIServiceInterface {
    public List<Hotel> getHotels(HotelSearchData hotelSearchData) throws NoSuchAlgorithmException, JsonProcessingException;
}
