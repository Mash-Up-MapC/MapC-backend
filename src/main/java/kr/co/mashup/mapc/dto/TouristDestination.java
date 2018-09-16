package kr.co.mashup.mapc.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
public class TouristDestination {
    @JsonProperty("name")
    private String name;

    @JsonProperty("img")
    private String img;

    @Builder
    public TouristDestination(String name, String img) {
        this.name = name;
        this.img = img;
    }
}
