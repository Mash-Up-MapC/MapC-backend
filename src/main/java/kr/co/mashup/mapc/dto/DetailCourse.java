package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class DetailCourse {

    @JsonProperty("id")
    private long id;

    @JsonProperty("img")
    private List<String> img;

    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private String price;

    @JsonProperty("oprating_time")
    private String operatingTime;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tourist_destination")
    private List<TouristAttractions> touristDestination;

    @JsonProperty("route")
    private List<CourseRoute> route;

    @JsonProperty("tourist_attractions")
    private List<TouristAttractions> touristAttractions;

    @Builder
    public DetailCourse(long id, List<String> img, String type, String name, String price, String operatingTime, String description, List<TouristAttractions> touristDestination, List<CourseRoute> route, List<TouristAttractions> touristAttractions) {
        this.id = id;
        this.img = img;
        this.type = type;
        this.name = name;
        this.price = price;
        this.operatingTime = operatingTime;
        this.description = description;
        this.touristDestination = touristDestination;
        this.route = route;
        this.touristAttractions = touristAttractions;
    }
}
