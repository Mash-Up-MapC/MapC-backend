package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
