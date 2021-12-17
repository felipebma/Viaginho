package aps.viaginho.hotelservice.services.api.adapters;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;
import aps.viaginho.hotelservice.services.api.APIService;

@Component
public class HotelAdapterImpl implements HotelAdapter {
    @Autowired
    APIService hotelAPIService;

    @Override
    public List<Hotel> getHotels(HotelSearchData hotelSearchData) {
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
