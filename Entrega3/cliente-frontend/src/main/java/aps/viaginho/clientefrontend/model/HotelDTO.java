package aps.viaginho.clientefrontend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    int code;
    String name;
    String minRate;
    String maxRate;
}
