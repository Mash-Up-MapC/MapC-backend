package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.Price;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@Value(staticConstructor = "of")
@Getter
public class StationDto {

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
        private String courseName;
        private String description;
        private String audioContent;
        private List<String> stationImageUrl;
        private List<InfoHistory> history;
        private List<InfoAttraction> attraction;
        private List<InfoRestaurant> restaurant;

        public ResGuideStation(String courseName,
                               String description,
                               String audioContent,
                               List<String> stationImageUrl,
                               List<InfoHistory> history,
                               List<InfoAttraction> attraction,
                               List<InfoRestaurant> restaurant) {

            this.courseName = courseName;
            this.description = description;
            this.audioContent = audioContent;
            this.stationImageUrl = stationImageUrl;
            this.history = history;
            this.attraction = attraction;
            this.restaurant = restaurant;
        }
//        public ResGuideStation(Course entity) {
//            this.id = entity.getId();
//            this.courseName = entity.getTitle();
//        }
    }

    @Data
    public static class InfoHistory {
        private String imageUrl;
        private String content;

        public InfoHistory (String imageUrl, String content) {
            this.imageUrl = imageUrl;
            this.content = content;
        }
    }

    @Data
    public static class InfoAttraction {
        private String imageUrl;
        private String title;
        private String content;

        public InfoAttraction(String imageUrl, String title, String content) {
            this.imageUrl = imageUrl;
            this.title = title;
            this.content = content;
        }
    }

    @Data
    public static class InfoRestaurant {
        private String imageUrl;
        private String title;
        private String content;

        public InfoRestaurant(String imageUrl, String title, String content) {
            this.imageUrl = imageUrl;
            this.title = title;
            this.content = content;
        }
    }
}
