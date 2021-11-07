package com.viaginho.viaginho.services;

import java.util.List;

import com.viaginho.viaginho.model.HotelReservation;
import com.viaginho.viaginho.repositories.HotelReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HotelService {
    @Autowired
    HotelReservationRepository hotelReservationRepository;

    public List<HotelReservation> getReservations(String userEmail) {
        List<HotelReservation> reservations = hotelReservationRepository.findAllByUserEmail(userEmail);
        System.out.println(reservations);
        return reservations;
    }

}
