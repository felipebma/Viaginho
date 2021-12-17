package aps.viaginho.hotelservice.collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.viaginho.hotelservice.model.HotelReservation;
import aps.viaginho.hotelservice.repositories.HotelReservationRepository;

@Component
public class HotelReservationCollection {

    @Autowired
    private HotelReservationRepository hotelReservationRepository;

    public HotelReservation save(HotelReservation hotelReservation) {
        return hotelReservationRepository.save(hotelReservation);
    }

    public List<HotelReservation> findAllByUserEmail(String userEmail) {
        return hotelReservationRepository.findAllByUserEmail(userEmail);
    }
}
