package aps.viaginho.hotelservice.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitySearchResponse implements Serializable {
    List<Suggestion> suggestions;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Suggestion implements Serializable {
        List<Entity> entities;
    }
    
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Entity implements Serializable {
        String destinationId;
    }
}
