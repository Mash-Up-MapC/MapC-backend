package kr.co.mashup.mapc.service;

import kr.co.mashup.mapc.dto.BookingDto;
import kr.co.mashup.mapc.dto.CourseDto;
import kr.co.mashup.mapc.dto.TouristDto;
import kr.co.mashup.mapc.entity.Booking;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.Tourist;
import kr.co.mashup.mapc.repository.BookingRepository;
import kr.co.mashup.mapc.repository.CourseRepository;
import kr.co.mashup.mapc.repository.TouristRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class BookingService {

    private CourseRepository courseRepository;
    private TouristRepository touristRepository;
    private BookingRepository bookingRepository;

    public List<CourseDto.CourseSelection> getCourse() {
        //TODO null 이면 에러 뜬다. 처리해야 한다. --> null 이라면 빈 객체 or 배열을 보낼 순 없을까?
        return courseRepository.findAll()
                .stream()
                .map(CourseDto.CourseSelection::new)
                .collect(Collectors.toList());
    }

    /**
     * 1. 전송 받은 uuid 가 디비에 있는지 조회를 한다.
     * 2. uuid 가 있다면, 기존 uuid row의 id 를 조회하여 booking 에 넣는다.
     * 3. uuid 가 없다면, 새로운 uuid 테이블 을 만든다.
     * 4. 새로운 tourist 테이블 로우의 id를 인서트 한다.
     * @param body
     */
    public void createBooking(BookingDto.BookingReqDto body) {

        Optional<Tourist> tourist = touristRepository.findByUuid(body.getUuid());
        Optional<Course> course = courseRepository.findById(body.getCourseId()); //TODO 코스아이디 null 일떄 예외 - Optional
        //TODO Optional 리팩토링 하기.
        if (tourist.isPresent()) { // 있다면
            log.info(tourist.get().toString());
            log.info("asdkjhasdj");
            bookingRepository.save(body.toBookingEntity(tourist.get(), course.get()));
        } else {
            TouristDto touristDto = new TouristDto(body.getUuid());
            Tourist createdTouristRow = touristRepository.save(touristDto.toTouristEntity());
            bookingRepository.save(body.toBookingEntity(createdTouristRow, course.get()));
        }
//        Optional<Course> course = courseRepository.findById(bDto.getCourseId());
//        log.info("{} : ", course);
//        //TODO course 가 null 일시 404 Exception 처리 --> Optional syntax 활용해보기.
//        course.ifPresent(course1 -> bookingRepository.save(bDto.toBookingEntity(course1)));
    }
}
