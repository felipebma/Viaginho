package com.viaginho.viaginho.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelSearchData {
    String city;
    String startDate;
    String endDate;
}
