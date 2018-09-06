package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.entity.StationImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by ethan.kim on 2018. 9. 1..
 */
public interface StationImageRepository extends JpaRepository<StationImage, Long> {
    Optional<List<StationImage>> findByStationId(long StationId);
}
