package kr.co.mashup.mapc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
//<<<<<<< HEAD
import kr.co.mashup.mapc.dto.CoursesDto;
//=======
import kr.co.mashup.mapc.dto.DetailCourseDto;
//>>>>>>> feature/is25-api-get-detail-course
import kr.co.mashup.mapc.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//<<<<<<< HEAD
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//=======
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//>>>>>>> feature/is25-api-get-detail-course

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@RestController
@Api(description = "코스", tags = {"course"})
@RequestMapping(value = "/courses", produces = "application/json")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @ApiOperation(value = "코스 리스트 조회", notes = "코스 리스트 조회를 한다")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공")
    })

    /*
    By 동희
     */
//    @GetMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<List<CoursesDto.CourseSelection>> getCourses() {
//        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
//    }

    @GetMapping(path = "/{course_Id}")
    public ResponseEntity<DetailCourseDto> getDetailCourse(@PathVariable(value = "course_Id") Long courseId) {
        return new ResponseEntity<>(courseService.getDetailCourse(courseId), HttpStatus.OK);

    }
}

