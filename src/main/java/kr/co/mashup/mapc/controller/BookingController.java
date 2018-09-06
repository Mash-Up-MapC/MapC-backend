package kr.co.mashup.mapc.controller;

import kr.co.mashup.mapc.dto.BookingDto;
import kr.co.mashup.mapc.dto.CourseDto;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/booking", produces = "application/json")
public class BookingController {

    private BookingService bookingService;

    /**
     *  Deprecated API
     */
    @GetMapping(path = "/course/list")
    public ResponseEntity<List<CourseDto.CourseSelection>> getCourse() {
        return new ResponseEntity<>(bookingService.getCourses(), HttpStatus.OK);
    }

    @PostMapping(path = "/course")
    public Map<String, String> bookingCourse(@RequestBody BookingDto.BookingReqDto body) {
        log.info("{}", body.getBookingDate());
        bookingService.createBooking(body);
        //TODO 출발지 설정할것 - 코스 ID 마다.
        Map<String,String> temp = new HashMap<>();
        temp.put("boardingPlace", "광화문");
        return temp;
    }
}
