package aps.viaginho.clientefrontend.services.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import aps.viaginho.clientefrontend.model.HotelDTO;
import aps.viaginho.clientefrontend.model.HotelReservation;
import aps.viaginho.clientefrontend.model.HotelSearchData;

@FeignClient(name = "hotel-service")
public interface HotelServiceProxy {

    @PostMapping
    public List<HotelDTO> getHotels(@RequestBody HotelSearchData hotelSearchData);

    @GetMapping("reservations")
    public List<HotelReservation> getReservations(@RequestParam String userEmail);

    @PostMapping("reservations")
    public HotelReservation createReservation(@RequestBody HotelReservation hotelReservation);

}
