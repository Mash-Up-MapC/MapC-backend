package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@Value(staticConstructor = "of")
public class CourseRoute {

    @JsonProperty("title")
    private String title;

    @JsonProperty("sub_title")
    private String subTitle;

    @JsonProperty("main_color")
    private String mainColor;

    @JsonProperty("options")
    private List<String> courseOptions;

    @JsonProperty("stations")
    private List<StationDto> stations;
}
