package aps.viaginho.hotelservice.services.api.adapters;

import java.util.List;

import org.springframework.stereotype.Component;

import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;

@Component
public interface HotelAdapter {
    public List<Hotel> getHotels(HotelSearchData hotelSearchData);
}
