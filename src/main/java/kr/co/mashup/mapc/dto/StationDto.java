package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Value;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@Value(staticConstructor = "of")
@Getter
public class StationDto {

    @JsonProperty("number")
    private final int stationNumber;

    @JsonProperty("name")
    private final String stationName;

    @JsonProperty("location")
    private final Location stationLocation;
}
