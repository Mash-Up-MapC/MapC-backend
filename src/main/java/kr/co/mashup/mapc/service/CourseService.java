package kr.co.mashup.mapc.service;


import kr.co.mashup.mapc.dto.CoursesDto;
import kr.co.mashup.mapc.dto.DetailCourseDto;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.repository.CourseOptionRepository;
import kr.co.mashup.mapc.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseOptionRepository courseOptionRepository;

    public CourseService(CourseRepository courseRepository, CourseOptionRepository courseOptionRepository) {
        this.courseRepository = courseRepository;
        this.courseOptionRepository = courseOptionRepository;
    }

//    fetchType.LAZY or EAGER
//    LAZY는 연결 된 엔티티가 있을 경우 연결 된 엔티티가 사용될때 가져온다.(지연로딩) LAZY를 사용해서 EAGER 효과를 보고싶을경우 @Transactional 사용
//    EAGER 엔티티를 가져올 때 연결된 엔티티까지 들고온다.(즉시로딩) *데이터가 크거나 사용하지 않을때도 들고 올 수 있다.
    @Transactional
    public List<CoursesDto.CourseSelection> getCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CoursesDto.CourseSelection::new)
                .collect(Collectors.toList());
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
