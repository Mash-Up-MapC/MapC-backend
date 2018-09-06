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

    @JsonProperty("course_name")
    private final String courseName;

    @JsonProperty("course_ information")
    private final String courseInformation;

    @JsonProperty("stations")
    private final List<StationDto> stations;
}
