package kr.co.mashup.mapc.service;

import kr.co.mashup.mapc.dto.CourseDto;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.repository.BookingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class BookingService {

    private BookingRepository bookingRepository;

    public List<CourseDto.CourseSelection> getCourse() {
        //TODO null 이면 에러 뜬다. 처리해야 한다. --> null 이라면 빈 객체 or 배열을 보낼 순 없을까?
        return bookingRepository.findAll()
                .stream()
                .map(CourseDto.CourseSelection::new)
                .collect(Collectors.toList());
    }
}
