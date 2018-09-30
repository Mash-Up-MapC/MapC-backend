package kr.co.mashup.mapc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import kr.co.mashup.mapc.dto.CoursesDto;

import kr.co.mashup.mapc.dto.DetailCourseDto;

import kr.co.mashup.mapc.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mashup.mapc.dto.TouristSpotDto;
import kr.co.mashup.mapc.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

      /*
    By 동희
     */
//    @ApiOperation(value = "코스 리스트 조회", notes = "코스 리스트 조회를 한다")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "조회 성공")
//    })
//    @GetMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<List<CoursesDto.CourseSelection>> getCourses() {
//        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK);
//    }


    @ApiOperation(value = "관광지 리스트 더 보기", notes = "관광지 리스트를 더 조회 한다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공")
    })
    @GetMapping(path = "/{course_Id}/{page}")
    public ResponseEntity<TouristSpotDto> getMoreTouristSpot(
            @PathVariable(value = "course_Id") Long courseId, @PathVariable(value = "page") int page) {
        return new ResponseEntity<TouristSpotDto>(courseService.getMoreTouristSpot(courseId, page), HttpStatus.OK);

    }
}

