package com.viaginho.viaginho.model;

import java.util.List;

public class ListHotelReservation {

    private List<HotelReservation> reservations;

    public ListHotelReservation(List<HotelReservation> reservations) {
        this.reservations = reservations;
    }

    public List<HotelReservation> getReservations() {
        return this.reservations;
    }
}
