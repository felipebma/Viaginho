package com.viaginho.viaginho.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelSearchResponse implements Serializable {
    public AuditData auditData;
    public List<Hotel> hotels;

    public static class AuditData implements Serializable {
        String processTime;
        String timestamp;
        String requestHost;
        String serverId;
        String environment;
        String release;
        String token;
        String internal;
    }
    
    public static class CancellationPolicy implements Serializable {
        String amount;
        Date from;
    }
    
    public static class Promotion implements Serializable {
        String code;
        String name;
    }
    
    public static class Offer implements Serializable {
        String code;
        String name;
        String amount;
    }
    
    public static class Rate implements Serializable {
        String rateKey;
        String rateClass;
        String rateType;
        String net;
        String sellingRate;
        boolean hotelMandatory;
        int allotment;
        String paymentType;
        boolean packaging;
        String boardCode;
        String boardName;
        List<CancellationPolicy> cancellationPolicies;
        int rooms;
        int adults;
        int children;
        List<Promotion> promotions;
        List<Offer> offers;
    }
    
    public static class Room implements Serializable {
        String code;
        String name;
        List<Rate> rates;
    }
    
    public static class Hotel implements Serializable {
        int code;
        String name;
        String categoryCode;
        String categoryName;
        String destinationCode;
        String destinationName;
        int zoneCode;
        String zoneName;
        String latitude;
        String longitude;
        List<Room> rooms;
        String minRate;
        String maxRate;
        String currency;
        List<Hotel> hotels;
        String checkIn;
        int total;
        String checkOut;
    }
}
