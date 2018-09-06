package kr.co.mashup.mapc.service;

import kr.co.mashup.mapc.dto.BookingDto;
import kr.co.mashup.mapc.entity.Booking;
import kr.co.mashup.mapc.entity.Station;
import kr.co.mashup.mapc.entity.Tourist;
import kr.co.mashup.mapc.repository.BookingRepository;
import kr.co.mashup.mapc.repository.StationRepository;
import kr.co.mashup.mapc.repository.TouristRepository;
import kr.co.mashup.mapc.util.MapcDateHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class GuideService {

    private TouristRepository touristRepository;
    private BookingRepository bookingRepository;

    private StationRepository stationRepository;

    /**
     * 1. tourist 검색
     * 1_1. 없다면 reject
     * 1_2. 있다면 tourist 가 요청 당일 예약을 했는지 check ( booking_date == Date.now() )
     * 2_1. 당일 예약 했다면. 다음 화면으로 넘어가면서 getInfo API Call
     * 2_2. 당일 예약 안했다면, reject
     */
    public boolean checkValidation(String uuid) {
        Optional<Tourist> tourist = touristRepository.findByUuid(uuid);
        //TODO Refactoring Optional
        if (tourist.isPresent()) {
            boolean flag = false;
            Optional<List<Booking>> bookingData = bookingRepository.findByTouristId(tourist.get().getId());
            if (bookingData.isPresent()) {
                for (int i = 0; i < bookingData.get().size(); i++) //TODO date 말고도 course 별로 체크 해야하는데 추후 개발.
                    if (flag = MapcDateHelper.compareTime(bookingData.get().get(i).getBookingDate())) break;
                return flag;
            } else return false; //TODO Fail 2_2
        } else return false; //TODO Fail 1_1
    }


    public void getBasicInfo() {
        Optional<Station> stationData = stationRepository.findById(Long.parseLong(String.valueOf(1)));
        if (stationData.isPresent()) {
            log.info(stationData.get().toString());
            log.info(stationData.get().getInformations().size() + "a");
            log.info(stationData.get().getStationImages().size() + "a");
//            log.info(stationData.get().getStationImages().size() + "a");
        } else {
            //Nothing
        }
    }
}
