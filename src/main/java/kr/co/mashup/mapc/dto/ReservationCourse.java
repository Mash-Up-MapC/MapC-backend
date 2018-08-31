package kr.co.mashup.mapc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@NoArgsConstructor
public class ReservationCourse {

    @JsonProperty("id")
    private long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("sub_title")
    private String subTitle;

    @JsonProperty("options")
    private List<String> options;

    @JsonProperty("main_color")
    private String mainColor;

    @JsonProperty("sub_color")
    private String subColor;

    @JsonProperty("icon")
    private String icon;

    @Builder
    public ReservationCourse(long id, String title, String subTitle, List<String> options, String mainColor, String subColor, String icon) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.options = options;
        this.mainColor = mainColor;
        this.subColor = subColor;
        this.icon = icon;
    }
}
