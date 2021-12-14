package aps.viaginho.clientefrontend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aps.viaginho.clientefrontend.model.HotelReservation;
import aps.viaginho.clientefrontend.model.HotelSearchData;
import aps.viaginho.clientefrontend.model.HotelSearchResponse.Hotel;
import aps.viaginho.clientefrontend.services.proxies.HotelServiceProxy;

@Service
public class HotelService {

    @Autowired
    private HotelServiceProxy hotelServiceProxy;

    public List<Hotel> getHotels(HotelSearchData hotelSearchData) {
        return hotelServiceProxy.getHotels(hotelSearchData);
    }

    public List<HotelReservation> getReservations(String userEmail) {
        return hotelServiceProxy.getReservations(userEmail);
    }

    public HotelReservation createReservation(HotelReservation hotelReservation) {
        return hotelServiceProxy.createReservation(hotelReservation);
    }

}
