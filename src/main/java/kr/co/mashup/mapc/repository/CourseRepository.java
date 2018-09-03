package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.CourseOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ethan.kim on 2018. 9. 1..
 */
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT DISTINCT c FROM Course c JOIN FETCH c.courseOptions co JOIN FETCH c.stations WHERE co.optionType = :optionType")
    List<Course> findCoursesWithStation(@Param("optionType") CourseOption.OptionType optionType);
}
