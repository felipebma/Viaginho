package com.viaginho.viaginho.model;

import java.util.List;

import com.viaginho.viaginho.model.HotelSearchResponse.Hotel;

public class ListHotel {

    private List<Hotel> reservations;

    public ListHotel(List<Hotel> reservations) {
        this.reservations = reservations;
    }

    public List<Hotel> getHotels() {
        return this.reservations;
    }
}
