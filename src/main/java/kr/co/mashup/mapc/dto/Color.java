package kr.co.mashup.mapc.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by ethan.kim on 2018. 7. 1..
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "code")
@ToString(of = "code")
public class Color {

    private String code;
}
