package com.viaginho.viaginho.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viaginho.viaginho.model.HotelSearchData;
import com.viaginho.viaginho.model.HotelSearchRequest;
import com.viaginho.viaginho.model.HotelSearchResponse;
import com.viaginho.viaginho.model.HotelSearchRequest.Filter;
import com.viaginho.viaginho.model.HotelSearchRequest.Geolocation;
import com.viaginho.viaginho.model.HotelSearchRequest.Stay;
import com.viaginho.viaginho.model.HotelSearchResponse.Hotel;
import com.viaginho.viaginho.services.adapters.HotelAdapterInterface;
import com.viaginho.viaginho.model.HotelSearchRequest.Occupancy;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HotelAPIService {
    private String apiKey = "cdab54fe60813921e59bf2ef12f5d61b";
    private String secret = "2b3434ea9a";
    private String baseUrl = "https://api.test.hotelbeds.com";

    private String getXSignature() throws NoSuchAlgorithmException {
        String signature = apiKey + secret + Long.toString(new Date().getTime()/1000);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[]hashInBytes = md.digest(signature.getBytes(StandardCharsets.UTF_8));

        //bytes to hex
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    public List<Hotel> getHotels(HotelSearchData hotelSearchData) throws NoSuchAlgorithmException, JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HotelSearchRequest hotelSearchRequest = new HotelSearchRequest();
        ObjectMapper objectMapper = new ObjectMapper();
        String url = baseUrl + "/hotel-api/1.0/hotels";
        String body;
        
        hotelSearchRequest.setStay(new Stay(hotelSearchData.getStartDate(), hotelSearchData.getEndDate()));
        hotelSearchRequest.setGeolocation(new Geolocation(hotelSearchData.getLatitude(), hotelSearchData.getLongitude(), 20, "km"));
        hotelSearchRequest.setOccupancies(Arrays.asList(new Occupancy(1,1,0)));
        hotelSearchRequest.setFilter(new Filter(20));

        body = objectMapper.writeValueAsString(hotelSearchRequest);

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Api-key", apiKey);
        headers.set("X-Signature", getXSignature());

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<HotelSearchResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, HotelSearchResponse.class);

        return response.getBody().getHotels().getHotels();
    }
}