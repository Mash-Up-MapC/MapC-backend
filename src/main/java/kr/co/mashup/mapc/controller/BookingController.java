package kr.co.mashup.mapc.controller;

import kr.co.mashup.mapc.dto.CourseDto;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/booking", produces = "application/json")
public class BookingController {

    private BookingService bookingService;

    @GetMapping(path = "/course/list")
    public ResponseEntity<List<CourseDto.CourseSelection>> getCourse() {
        return new ResponseEntity<>(bookingService.getCourses(), HttpStatus.OK);
    }
}
