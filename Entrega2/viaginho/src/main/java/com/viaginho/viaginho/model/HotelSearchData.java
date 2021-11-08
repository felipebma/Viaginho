package com.viaginho.viaginho.model;

import com.viaginho.viaginho.model.validation.HotelSearchDataValidation.HotelSearchDataValid;

import org.springframework.stereotype.Component;

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
