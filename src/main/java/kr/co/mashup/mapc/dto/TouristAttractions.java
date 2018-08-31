package kr.co.mashup.mapc.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TouristAttractions {

    @JsonProperty("name")
    private String name;

    @JsonProperty("img")
    private String img;

    @JsonProperty("description")
    private String description;

    @Builder
    public TouristAttractions(String name, String img, String description) {
        this.name = name;
        this.img = img;
        this.description = description;
    }
}
