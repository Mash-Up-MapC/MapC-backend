package kr.co.mashup.mapc.dto;


import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@ToString
@Slf4j
public class TouristAttractionsDto {
    private String name;
    private String img;
    private String description;
}
