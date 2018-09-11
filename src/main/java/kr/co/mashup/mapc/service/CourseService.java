package kr.co.mashup.mapc.service;


import kr.co.mashup.mapc.dto.CoursesDto;
import kr.co.mashup.mapc.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CoursesDto.CourseSelection> getCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CoursesDto.CourseSelection::new)
                .collect(Collectors.toList());
    }

}
