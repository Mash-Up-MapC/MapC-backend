package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@Value(staticConstructor = "of")
public class Location {

    @JsonProperty("lat")
    private double latitude;

    @JsonProperty("lng")
    private double longitude;
}
