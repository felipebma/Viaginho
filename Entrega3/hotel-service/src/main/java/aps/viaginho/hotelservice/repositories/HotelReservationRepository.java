package aps.viaginho.hotelservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import aps.viaginho.hotelservice.model.HotelReservation;

public interface HotelReservationRepository extends MongoRepository<HotelReservation, String> {
    public List<HotelReservation> findAllByUserEmail(String userEmail);
}
