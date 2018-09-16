package kr.co.mashup.mapc.service;


import kr.co.mashup.mapc.dto.TouristAttractions;
import kr.co.mashup.mapc.dto.TouristSpotDto;
import kr.co.mashup.mapc.entity.Station;
import kr.co.mashup.mapc.repository.StationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseService {

    private final StationRepository stationRepository;

    public CourseService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Transactional
    public TouristSpotDto getMoreTouristSpot(Long courseId, int page) {
        List<TouristAttractions> touristAttractionsList = new ArrayList<>();


        PageRequest pageRequest = new PageRequest(page,3, Sort.Direction.ASC,"courseId");

        Page<Station> result = stationRepository.findByCourseId(courseId, pageRequest);

        List<Station> stations = result.getContent();

        for(Station s : stations) {
            TouristAttractions touristAttractions = TouristAttractions.
                    builder().
                    name(s.getName()).
                    description(s.getDescription()).
                    build();
            touristAttractionsList.add(touristAttractions);
        }


        return TouristSpotDto.
                builder().
                page(page + 1).
                touristAttractionsList(touristAttractionsList).
                build();

    }

}
