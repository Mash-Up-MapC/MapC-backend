package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Value;

import java.util.List;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@Value(staticConstructor = "of")
@Getter
public class CourseRoute {

    @JsonProperty("title")
    private final String title;

    @JsonProperty("sub_title")
    private final String subTitle;

    @JsonProperty("main_color")
    private final String mainColor;

    @JsonProperty("options")
    private final List<String> courseOptions;

    @JsonProperty("stations")
    private final List<StationDto> stations;
}
