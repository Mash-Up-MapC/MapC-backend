package kr.co.mashup.mapc.service;

import kr.co.mashup.mapc.dto.BookingDto;
import kr.co.mashup.mapc.dto.CourseDto;
import kr.co.mashup.mapc.dto.TouristDto;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.Tourist;
import kr.co.mashup.mapc.repository.BookingRepository;
import kr.co.mashup.mapc.repository.CourseRepository;
import kr.co.mashup.mapc.repository.TouristRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class BookingService {

    private CourseRepository courseRepository;
    private TouristRepository touristRepository;
    private BookingRepository bookingRepository;

    public List<CourseDto.CourseSelection> getCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseDto.CourseSelection::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void createBooking(BookingDto.BookingReqDto body) {
        Optional<Tourist> tourist = touristRepository.findByUuid(body.getUuid()); //TODO tourist null 이면 에러 뜬다.
        Optional<Course> course = courseRepository.findById(body.getCourseId()); //TODO 코스아이디 null 일떄 예외 - Optional
//        boolean isSuccess = false;
        //TODO Optional 리팩토링 하기.
        if (tourist.isPresent()) { // 있다면
            log.info(tourist.get().toString());
            bookingRepository.save(body.toBookingEntity(tourist.get(), course.get()));
//            isSuccess = true;
        } else {
            TouristDto touristDto = new TouristDto(body.getUuid());
            Tourist createdTouristRow = touristRepository.save(touristDto.toTouristEntity());
            bookingRepository.save(body.toBookingEntity(createdTouristRow, course.get()));
//            isSuccess = true;
        }
//        if (isSuccess) return course.get().getId(); //TODO 리팩토링
//        else return 0;
//        Optional<Course> course = courseRepository.findById(bDto.getCourseId());
//        log.info("{} : ", course);
//        //TODO course 가 null 일시 404 Exception 처리 --> Optional syntax 활용해보기.
//        course.ifPresent(course1 -> bookingRepository.save(bDto.toBookingEntity(course1)));

    }
}
