package com.viaginho.viaginho.services.adapters;

import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.HotelSearchResponse.Hotel;
import com.viaginho.viaginho.services.HotelAPIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelAdapter implements HotelAdapterInterface{
    @Autowired HotelAPIService hotelAPIService;

    @Override
    public List<Hotel> getHotels(HotelSearchData hotelSearchData) throws NoSuchAlgorithmException, JsonProcessingException {
          Double latitude, longitude;
            switch(hotelSearchData.getCity()) {
                case "recife":
                    latitude = -8.05428;
                    longitude = -34.8813;
                    break;
                case "saoPaulo":
                    latitude = -23.5489;
                    longitude = -46.6388;
                    break;
                case "rioDeJaneiro":
                    latitude = -22.9035;
                    longitude = -43.2096;
                    break;
                default:
                    throw new InvalidParameterException("Cidade invalida");
            }
            hotelSearchData.setLatitude(latitude);
            hotelSearchData.setLongitude(longitude);
            
            List<Hotel> hotels = hotelAPIService.getHotels(hotelSearchData);
            System.out.println(hotels.size());
            return hotels;
    }
}
