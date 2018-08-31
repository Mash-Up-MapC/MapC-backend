package kr.co.mashup.mapc.service;

import kr.co.mashup.mapc.dto.CourseDto;
import kr.co.mashup.mapc.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<CourseDto.CourseSelection> getCourse() {
        return bookingRepository.findAll()
                .stream()
                .map(CourseDto.CourseSelection::new)
                .collect(Collectors.toList());
    }
}
