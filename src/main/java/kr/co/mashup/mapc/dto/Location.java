package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Value;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@Value(staticConstructor = "of")
@Getter
public class Location {

    @JsonProperty("lat")
    private final double latitude;

    @JsonProperty("lng")
    private final double longitude;
}
