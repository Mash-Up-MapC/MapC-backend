package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ethan.kim on 2018. 9. 1..
 */
public interface CourseRepository extends JpaRepository<Course, Long> {

}
