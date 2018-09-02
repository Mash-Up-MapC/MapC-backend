package kr.co.mashup.mapc.service;

import kr.co.mashup.mapc.dto.CourseDto;
import kr.co.mashup.mapc.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final CourseRepository courseRepository;

    public BookingService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto.CourseSelection> getCoueses() {
        return courseRepository.findAll()
                .stream()
                .map(CourseDto.CourseSelection::new)
                .collect(Collectors.toList());
    }
}
