package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.Price;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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

    @Data
    @ToString
    @Slf4j
    public static class ResGuideStation { //TODO Response 구조 생각
        private long id;
        private String courseName;
        private String description;
        private String audioContent;
        private List<String> stationUrl;
        private List<InfoHistory> history;
        private List<InfoAttraction> attraction;
        private List<InfoRestaurant> restaurant;
    }

    @Data
    public class InfoHistory {
        private String imageUrl;
        private String content;
    }

    @Data
    public class InfoAttraction {
        private String imageUrl;
        private String title;
        private String content;
    }

    @Data
    public class InfoRestaurant {
        private String imageUrl;
        private String title;
        private String content;
    }
}
