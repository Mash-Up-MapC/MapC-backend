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

import kr.co.mashup.mapc.dto.TouristAttractions;
import kr.co.mashup.mapc.dto.TouristSpotDto;
import kr.co.mashup.mapc.entity.Station;
import kr.co.mashup.mapc.repository.StationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseService {

//    private final StationRepository stationRepository;

//    public CourseService(StationRepository stationRepository) {
//        this.stationRepository = stationRepository;
//    }

    private final CourseRepository courseRepository;
    private final CourseOptionRepository courseOptionRepository;
    private final StationRepository stationRepository;

    public CourseService(CourseRepository courseRepository, CourseOptionRepository courseOptionRepository, StationRepository stationRepository) {
        this.courseRepository = courseRepository;
        this.courseOptionRepository = courseOptionRepository;
        this.stationRepository = stationRepository;
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
        if (course.isPresent()) {
            detailCourseDto = new DetailCourseDto();

            detailCourseDto.convertToDto(course.get());


        } else {
            detailCourseDto = null;
        }
        return detailCourseDto;
    }

    @Transactional
    public TouristSpotDto getMoreTouristSpot(Long courseId, int page) {
        List<TouristAttractions> touristAttractionsList = new ArrayList<>();

        //spring data paging 처리 (조회 할 페이지, 페이지의 데이터의 수, 정렬방식, 정렬정보)
        PageRequest pageRequest = new PageRequest(page, 3, Sort.Direction.ASC, "courseId");

        Page<Station> result = stationRepository.findByCourseId(courseId, pageRequest);

        //페이징처리된 데이터가 있는지 없는지 판단
        if (result.hasContent()) {

            List<Station> stations = result.getContent();

            for (Station s : stations) {
                TouristAttractions touristAttractions = TouristAttractions.
                        builder().
                        name(s.getName()).
                        img("https://s3.ap-northeast-2.amazonaws.com/key-s3/mapc/%E1%84%82%E1%85%A1%E1%86%B7%E1%84%89%E1%85%A1%E1%86%AB+%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%87%E1%85%B3%E1%86%AF%E1%84%8F%E1%85%A1.JPG").
                        description(s.getDescription()).
                        build();
                touristAttractionsList.add(touristAttractions);
                //s.getStationImages().get(0).getImageUrl() 추후 디비에 이미지 추가시 변경
            }

        } else {
            page = -1;
        }
        return TouristSpotDto.
                builder().
                page(page).
                touristAttractionsList(touristAttractionsList).
                build();

    }

}
