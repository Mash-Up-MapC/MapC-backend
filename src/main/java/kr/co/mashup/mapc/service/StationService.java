package kr.co.mashup.mapc.service;

import kr.co.mashup.mapc.dto.CourseRoute;
import kr.co.mashup.mapc.dto.Location;
import kr.co.mashup.mapc.dto.StationDto;
import kr.co.mashup.mapc.entity.CourseOption;
import kr.co.mashup.mapc.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ethan.kim on 2018. 9. 2..
 */
@Service
public class StationService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public List<CourseRoute> getCourses() {
        return courseRepository.findCoursesWithStation(CourseOption.OptionType.ROUTE).stream()
                .map(course -> CourseRoute.of(
                        course.getTitle(),
                        course.getSubTitle(),
                        course.getMainColor(),
                        course.getCourseOptions().stream()
                                .map(CourseOption::getOptionValue)
                                .collect(Collectors.toList()),
                        course.getStations().stream()
                                .map(station -> StationDto.of(station.getNumber(), station.getName(),
                                        Location.of(station.getLatitude(), station.getLongitude())))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
