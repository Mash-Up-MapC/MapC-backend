package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
    Optional<Tourist> findByUuid(String uuid);
}
