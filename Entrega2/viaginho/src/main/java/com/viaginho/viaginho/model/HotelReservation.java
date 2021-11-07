package com.viaginho.viaginho.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelReservation {
    @Id
    Long id;
    String hotelId;
    String hotelName;
    String userEmail;
    // Room room;
    // Date checkInDate;
    // Date checkOutDate;
    Double price;

    public HotelReservation(Long id, String hotelName, String userEmail, Double price){
        this.id = id;
        this.hotelName = hotelName;
        this.userEmail = userEmail;
        this.price = price;
    }
}
