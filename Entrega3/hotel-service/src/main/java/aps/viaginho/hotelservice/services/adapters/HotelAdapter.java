package aps.viaginho.hotelservice.services.adapters;

import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;
import aps.viaginho.hotelservice.services.HotelAPIService;

@Component
public class HotelAdapter implements HotelAdapterInterface {
    @Autowired
    HotelAPIService hotelAPIService;

    @Override
    public List<Hotel> getHotels(HotelSearchData hotelSearchData) {
        try {
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
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
