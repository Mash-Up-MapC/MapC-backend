package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class TouristSpotDto {

    @JsonProperty("page")
    private int page;

    @JsonProperty("tourist_attractions")
    private List<TouristAttractions> touristAttractionsList;

    @Builder
    public TouristSpotDto(int page, List<TouristAttractions> touristAttractionsList) {
        this.page = page;
        this.touristAttractionsList = touristAttractionsList;
    }
}
