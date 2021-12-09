package com.viaginho.viaginho.services.adapters;

import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.ListHotel;
import com.viaginho.viaginho.model.HotelSearchResponse.Hotel;
import com.viaginho.viaginho.services.HotelAPIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelAdapter implements HotelAdapterInterface {
    @Autowired
    HotelAPIService hotelAPIService;

    @Override
    public ListHotel getHotels(HotelSearchData hotelSearchData)
            throws NoSuchAlgorithmException, JsonProcessingException {
        Double latitude, longitude;
        switch (hotelSearchData.getCity()) {
            case "Recife":
                latitude = -8.05428;
                longitude = -34.8813;
                break;
            case "São Paulo":
                latitude = -23.5489;
                longitude = -46.6388;
                break;
            case "Rio De Janeiro":
                latitude = -22.9035;
                longitude = -43.2096;
                break;
            default:
                throw new InvalidParameterException("Cidade invalida");
        }
        hotelSearchData.setLatitude(latitude);
        hotelSearchData.setLongitude(longitude);

       return hotelAPIService.getHotels(hotelSearchData);
    }
}
