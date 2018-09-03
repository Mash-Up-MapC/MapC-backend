package kr.co.mashup.mapc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.mashup.mapc.dto.CourseRoute;
import kr.co.mashup.mapc.service.StationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@RestController
@RequestMapping(path = "/courses/route", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(description = "코스별 노선", tags = {"route"})
public class CourseRouteController {

    private final StationService stationService;

    public CourseRouteController(StationService stationService) {
        this.stationService = stationService;
    }

    @ApiOperation(value = "코스의 버스 노선 리스트 조회", notes = "코스의 버스 노선 리스트를 조회한다")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공")
    })
    @GetMapping
    public ResponseEntity<List<CourseRoute>> getCourseRoute() {
        return ResponseEntity.ok(stationService.getCourses());
    }
}
