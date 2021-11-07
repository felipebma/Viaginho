package com.viaginho.viaginho.repositories;

import java.util.List;

import com.viaginho.viaginho.model.HotelReservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelReservationRepository extends MongoRepository<HotelReservation, String> {
    public List<HotelReservation> findAllByUserEmail(String userEmail);
}
