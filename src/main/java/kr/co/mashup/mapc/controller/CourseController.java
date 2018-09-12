package kr.co.mashup.mapc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.mashup.mapc.dto.DetailCourse;
import kr.co.mashup.mapc.dto.TouristAttractions;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@RestController
@Api(description = "코스", tags = {"course"})
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @ApiOperation(value = "코스 상세보기 조회", notes = "코스 상세보기 조회 한다")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공")
    })
    @GetMapping(path = "/courses/{course_Id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getDetailCourse(@PathVariable(value = "course_Id") Long courseId) {
        return new ResponseEntity<>(courseService.getDetailCourse(courseId), HttpStatus.OK);
    }
}

