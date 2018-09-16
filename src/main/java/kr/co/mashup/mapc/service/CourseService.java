package kr.co.mashup.mapc.service;


import kr.co.mashup.mapc.repository.StationRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final StationRepository stationRepository;

    public CourseService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public void getMoreTouristSpot(Long courseId, int page) {

    }

}
