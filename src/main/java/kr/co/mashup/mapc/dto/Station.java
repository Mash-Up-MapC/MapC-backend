package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Value;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@Value(staticConstructor = "of")
@Getter
public class Station {

    @JsonProperty("stations_number")
    private final int stationsNumber;

    @JsonProperty("station_name")
    private final String stationName;

    @JsonProperty("station_location")
    private final Location stationLocation;
}
