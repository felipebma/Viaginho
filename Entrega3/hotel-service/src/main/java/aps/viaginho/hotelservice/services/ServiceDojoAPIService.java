package aps.viaginho.hotelservice.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import aps.viaginho.hotelservice.model.CitySearchResponse;
import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;
import aps.viaginho.hotelservice.model.RapidAPIHotelResponse;
import aps.viaginho.hotelservice.model.RapidAPIHotelResponse.Result;

@Service
@Primary
public class ServiceDojoAPIService implements HotelAPIServiceInterface {
    private String apiKey = "7dfffcee7dmsh930cd6321468b50p11a9f8jsn1727735b9038";
    private String host = "hotels4.p.rapidapi.com";

    private String getCityId(HotelSearchData hotelSearchData) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "https://hotels4.p.rapidapi.com/locations/v2/search?query=%s&locale=en_US&currency=USD";

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-rapidapi-host", host);
        headers.set("x-rapidapi-key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<CitySearchResponse> response = restTemplate.exchange(
                String.format(url, hotelSearchData.getCity()), HttpMethod.GET, entity,
                CitySearchResponse.class);

        return response.getBody().getSuggestions().get(0).getEntities().get(0).getDestinationId();
    }

    public List<Hotel> getHotels(HotelSearchData hotelSearchData) {
        String cityId;
        cityId = getCityId(hotelSearchData);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "https://hotels4.p.rapidapi.com/properties/list?destinationId=%s&pageNumber=1&pageSize=25&checkIn=%s&checkOut=%s&adults1=1&sortOrder=STAR_RATING_HIGHEST_FIRST&locale=en_US&currency=USD";

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-rapidapi-host", host);
        headers.set("x-rapidapi-key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<RapidAPIHotelResponse> response = restTemplate.exchange(
                String.format(url, cityId, hotelSearchData.getStartDate(), hotelSearchData.getEndDate()),
                HttpMethod.GET, entity,
                RapidAPIHotelResponse.class);

        List<Hotel> hotels = new ArrayList<Hotel>();

        for (int i = 0; i < response.getBody().getData().getBody().getSearchResults().getResults().size(); i++) {
            Result result = response.getBody().getData().getBody().getSearchResults().getResults().get(i);
            if (result.getRatePlan() == null)
                continue;

            Hotel hotel = new Hotel();
            hotel.setName(result.getName());
            hotel.setMinRate(result.getRatePlan().getPrice().getExactCurrent().toString());
            hotel.setMaxRate(result.getRatePlan().getPrice().getExactCurrent().toString());
            hotels.add(hotel);
        }

        return hotels;
    }
}
