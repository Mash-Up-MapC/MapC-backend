package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.entity.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ethan.kim on 2018. 9. 1..
 */
public interface StationRepository extends JpaRepository<Station, Long> {
    Page<Station> findByCourseId(Long courseId, Pageable Pageable);

}
