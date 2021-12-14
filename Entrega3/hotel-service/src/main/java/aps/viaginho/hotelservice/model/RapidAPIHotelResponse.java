package aps.viaginho.hotelservice.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RapidAPIHotelResponse implements Serializable {
    RequestData data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestData implements Serializable {
        RequestBody body;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestBody implements Serializable {
        SearchResult searchResults;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchResult implements Serializable {
        List<Result> results;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Price implements Serializable {
        Double exactCurrent;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RatePlan implements Serializable {
        Price price;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result implements Serializable {
        String name;
        RatePlan ratePlan;
    }
}
