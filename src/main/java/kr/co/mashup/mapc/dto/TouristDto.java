package kr.co.mashup.mapc.dto;

import kr.co.mashup.mapc.entity.Tourist;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TouristDto {

    private String uuid;

    public TouristDto(String uuid) {
        this.uuid = uuid;
    }

    public Tourist toTouristEntity() {
        return Tourist.builder()
                .uuid(uuid)
                .build();
    }
}

