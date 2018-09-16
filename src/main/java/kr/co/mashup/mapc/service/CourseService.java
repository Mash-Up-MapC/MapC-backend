package kr.co.mashup.mapc.service;


import kr.co.mashup.mapc.dto.DetailCourseDto;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.repository.CourseOptionRepository;
import kr.co.mashup.mapc.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseOptionRepository courseOptionRepository;

    public CourseService(CourseRepository courseRepository, CourseOptionRepository courseOptionRepository) {
        this.courseRepository = courseRepository;
        this.courseOptionRepository = courseOptionRepository;
    }

    @Transactional
    public DetailCourseDto getDetailCourse(Long courseId) {
        DetailCourseDto detailCourseDto;


        //Optional 반환되는 객체를 담아서 null인지 아닌지 체크하는 클래스
        Optional<Course> course = courseRepository.findById(courseId);

        //null 체크여부
        if(course.isPresent()) {
            detailCourseDto = new DetailCourseDto();

            detailCourseDto.convertToDto(course.get());


        } else {
            detailCourseDto = null;
        }
        return detailCourseDto;
    }

}
