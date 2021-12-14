package aps.viaginho.hotelservice.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import aps.viaginho.hotelservice.model.HotelSearchData;
import aps.viaginho.hotelservice.model.HotelSearchRequest;
import aps.viaginho.hotelservice.model.HotelSearchRequest.Filter;
import aps.viaginho.hotelservice.model.HotelSearchRequest.Geolocation;
import aps.viaginho.hotelservice.model.HotelSearchRequest.Occupancy;
import aps.viaginho.hotelservice.model.HotelSearchRequest.Stay;
import aps.viaginho.hotelservice.model.HotelSearchResponse;
import aps.viaginho.hotelservice.model.HotelSearchResponse.Hotel;

@Component
public class HotelBedsAPIService implements HotelAPIServiceInterface {
    private String apiKey = "f20f73f205f227545329991990abef5b";
    private String secret = "cc5b9bb2e8";
    private String baseUrl = "https://api.test.hotelbeds.com";

    private String getXSignature() throws NoSuchAlgorithmException {
        String signature = apiKey + secret + Long.toString(new Date().getTime() / 1000);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return HexUtils.toHexString(md.digest(signature.getBytes(StandardCharsets.UTF_8)));
    }

    public List<Hotel> getHotels(HotelSearchData hotelSearchData)
            throws NoSuchAlgorithmException, JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HotelSearchRequest hotelSearchRequest = new HotelSearchRequest();
        ObjectMapper objectMapper = new ObjectMapper();
        String url = baseUrl + "/hotel-api/1.0/hotels";
        String body;

        hotelSearchRequest.setStay(new Stay(hotelSearchData.getStartDate(), hotelSearchData.getEndDate()));
        hotelSearchRequest.setGeolocation(
                new Geolocation(hotelSearchData.getLatitude(), hotelSearchData.getLongitude(), 20, "km"));
        hotelSearchRequest.setOccupancies(Arrays.asList(new Occupancy(1, 1, 0)));
        hotelSearchRequest.setFilter(new Filter(20));

        body = objectMapper.writeValueAsString(hotelSearchRequest);

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Api-key", apiKey);
        headers.set("X-Signature", getXSignature());

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<HotelSearchResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity,
                HotelSearchResponse.class);

        return response.getBody().getHotels().getHotels();
    }
}
