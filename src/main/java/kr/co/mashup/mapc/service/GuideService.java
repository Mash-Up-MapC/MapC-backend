package kr.co.mashup.mapc.service;

import kr.co.mashup.mapc.dto.StationDto;
import kr.co.mashup.mapc.entity.Booking;
import kr.co.mashup.mapc.entity.Station;
import kr.co.mashup.mapc.entity.StationImage;
import kr.co.mashup.mapc.entity.Tourist;
import kr.co.mashup.mapc.repository.BookingRepository;
import kr.co.mashup.mapc.repository.StationImageRepository;
import kr.co.mashup.mapc.repository.StationRepository;
import kr.co.mashup.mapc.repository.TouristRepository;
import kr.co.mashup.mapc.util.MapcDateHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class GuideService {

    private TouristRepository touristRepository;
    private BookingRepository bookingRepository;

    private StationRepository stationRepository;
    private StationImageRepository stationImageRepository;

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


    public StationDto.ResGuideStation getBasicInfo() {
        StationDto.ResGuideStation resGuideStation = null;
        List<String> stationImage = new ArrayList<>();
        List<StationDto.InfoHistory> history = new ArrayList<>();
        List<StationDto.InfoAttraction> attraction = new ArrayList<>(); //123
        List<StationDto.InfoRestaurant> restaurant = new ArrayList<>(); //456

        Optional<Station> stationData = stationRepository.findById(Long.parseLong(String.valueOf(1)));
        Optional<List<StationImage>> stationImages = stationImageRepository.findByStationId(Long.parseLong(String.valueOf(1)));
        if (stationData.isPresent() && stationImages.isPresent()) {
                // TODO 병렬로 작업하면 효율적일듯
                stationImage.add(stationImages.get().get(0).getImageUrl());
                stationImage.add(stationImages.get().get(1).getImageUrl());
                stationImage.add(stationImages.get().get(2).getImageUrl());
            history.add(new StationDto.InfoHistory(stationData.get().getInformations().get(0).getImageUrl(),
                    stationData.get().getInformations().get(0).getContent()));

            for (int i = 1; i < 4; i++) {
                attraction.add(new StationDto.InfoAttraction(stationData.get().getInformations().get(i).getImageUrl(),
                        stationData.get().getInformations().get(i).getContent(),
                        stationData.get().getInformations().get(i).getTitle()));
            }

            for (int i = 4; i < 7; i++) {
                restaurant.add(new StationDto.InfoRestaurant(stationData.get().getInformations().get(i).getImageUrl(),
                        stationData.get().getInformations().get(i).getContent(),
                        stationData.get().getInformations().get(i).getTitle()));
            }


            resGuideStation = new StationDto.ResGuideStation(stationData.get().getName(),
                    stationData.get().getDescription(),
                    stationData.get().getAudioContent(),
                    stationImage,
                    history,
                    attraction,
                    restaurant);
            log.info(stationData.get().toString());
            log.info(resGuideStation.toString());
            return resGuideStation;
//            log.info(stationData.get().getInformations().size() + "a");
//            log.info(stationData.get().getStationImages().size() + "a"); //TODO Err : failed to lazily initialize a collection of role -- REF : https://stackoverflow.com/questions/11746499/how-to-solve-the-failed-to-lazily-initialize-a-collection-of-role-hibernate-ex
        } else {
            //Nothing
        }
        return null;
    }
}
