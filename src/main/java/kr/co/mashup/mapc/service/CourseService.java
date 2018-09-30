package kr.co.mashup.mapc.service;


import kr.co.mashup.mapc.dto.CoursesDto;
import kr.co.mashup.mapc.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    //fetchType.LAZY or EAGER
    //LAZY는 연결 된 엔티티가 있을 경우 연결 된 엔티티가 사용될때 가져온다.(지연로딩) LAZY를 사용해서 EAGER 효과를 보고싶을경우 @Transactional 사용
    //EAGER 엔티티를 가져올 때 연결된 엔티티까지 들고온다.(즉시로딩) *데이터가 크거나 사용하지 않을때도 들고 올 수 있다.
    @Transactional
    public List<CoursesDto.CourseSelection> getCourses() {
        return courseRepository.findAll()
                .stream()
                .map(CoursesDto.CourseSelection::new)
                .collect(Collectors.toList());
    }

}
