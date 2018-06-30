package kr.co.mashup.mapc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.mashup.mapc.dto.Color;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ethan.kim on 2018. 7. 1..
 */
@RestController
@Api(description = "색깔", tags = {"color"})
public class ColorController {

    @ApiOperation(value = "Color 리스트 조회", notes = "Color 리스트 조회한다")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @GetMapping(path = "/color")
    public List<Color> getColor() {
        return Arrays.asList(generateColor("#aaaaaa"), generateColor("#bbbbbb"));
    }

    @ApiOperation(value = "Color 배색 추천", notes = "Color 배색을 조회한다")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    @GetMapping(path = "/color/coloration")
    public List<Color> getColorColoration(HttpServletRequest request) {
        String selectionColor = request.getParameter("selectionColor");
        //선택한색을 가지고 배색을 얻어오는 서비스로직을 이용한다.
        //return Arrays.asList(getColoration(selectionColor));
        return Arrays.asList(generateColor("#aaaaaa"), generateColor("#bbbbbb"));
    }

    private Color generateColor(String code) {
        Color color = new Color();
        color.setCode(code);
        return color;
    }

}
