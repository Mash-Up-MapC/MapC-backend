package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    //TODO 필요한 컬럼만 가져올려면? 찾아보자 -- findALl 한다음 데이터 DTO 에 담는게 불필요 한거 아닌가?
}
