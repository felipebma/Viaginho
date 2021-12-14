package aps.viaginho.hotelservice.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelSearchRequest implements Serializable {
    Stay stay;
    Geolocation geolocation;
    Filter filter;
    List<Occupancy> occupancies;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Stay implements Serializable {
        String checkIn;
        String checkOut;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Geolocation implements Serializable {
        Double latitude;
        Double longitude;
        int radius;
        String unit;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Occupancy implements Serializable {
        int rooms;
        int adults;
        int children;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Filter implements Serializable {
        int maxHotels;
    }
}
