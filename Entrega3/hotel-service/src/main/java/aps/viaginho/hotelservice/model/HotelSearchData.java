package aps.viaginho.hotelservice.model;

import org.springframework.stereotype.Component;

import aps.viaginho.hotelservice.model.validation.HotelSearchDataValidation.HotelSearchDataValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@HotelSearchDataValid(message = "Datas inválidas")
public class HotelSearchData {
    String city;
    String startDate;
    String endDate;
    Double latitude;
    Double longitude;
}
