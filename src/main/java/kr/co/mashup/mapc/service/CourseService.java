package kr.co.mashup.mapc.service;


import kr.co.mashup.mapc.repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public String getDetailCourse(Long courseId) {
        return "hello";
    }

}
