package aps.viaginho.clientefrontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelReservation {
    String id;
    String hotelId;
    String hotelName;
    String userEmail;
    String checkInDate;
    String checkOutDate;
    Double price;

    public HotelReservation(String hotelId, String hotelName, String userEmail, String checkInDate, String checkOutDate,
            Double price) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.userEmail = userEmail;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
    }

}
