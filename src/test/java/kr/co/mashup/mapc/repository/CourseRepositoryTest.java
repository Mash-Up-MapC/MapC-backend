package kr.co.mashup.mapc.repository;


import kr.co.mashup.mapc.DataJpaTestContext;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.CourseOption;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ethan.kim on 2018. 9. 1..
 */
public class CourseRepositoryTest extends DataJpaTestContext {

    @Autowired
    private CourseRepository sut;

    @Test
    public void 코스_리스트_조회시_코스_옵션과_정류장_정보를_같이_조회한다() {
        // given :
        CourseOption.OptionType optionType = CourseOption.OptionType.ROUTE;

        // when :
        List<Course> courses = sut.findCoursesWithStation(optionType);

        // then :
        assertThat(courses).isNotEmpty();
        courses.forEach(course -> {
            assertThat(course.getStations()).isNotEmpty();
            assertThat(course.getCourseOptions()).isNotEmpty();
        });
    }
}
