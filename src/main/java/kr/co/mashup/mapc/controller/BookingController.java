package kr.co.mashup.mapc.controller;

import kr.co.mashup.mapc.dto.BookingDto;
import kr.co.mashup.mapc.dto.CourseDto;
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
        return new ResponseEntity<>(bookingService.getCourse(), HttpStatus.OK);
    }

    // 예약 을 하려고 하는사람만 uuid 를 받아서 테이블 에 저장 하면 어떨려나?
    /**
     * 0. 코스 id
     * 1. 인원
     *   1_1. 성인
     *   1_2. 학생
     * 2. 날짜
     * 3. 탑승시간 -- 이것도 기획이 안정해졌다.
     * 4. 예약정보
     *   4_1. 예약자이름
     *   4_2. 예약자연락처
     * 5. 결제금액 (클라에서 계산후 전송)
     * 6. 결제방법 // (PG가 있다면, 결제방법은 정해져있다.)
     * @param bDto
     */
    @PostMapping(path = "/course")
    public void bookingCourse(@RequestBody BookingDto.BookingReqDto body) {
//        log.info("{}", bDto.getBookingDate());
        bookingService.createBooking(body);
    }
}
