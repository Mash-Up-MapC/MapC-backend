package kr.co.mashup.mapc.dto;

import kr.co.mashup.mapc.entity.Booking;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.Tourist;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@ToString
@Slf4j
public class BookingDto {

    @Data
    public static class BookingReqDto {
        private String uuid;
        private Long courseId;
        private Integer adultPersonnel;
        private Integer childPersonnel;
        private Date bookingDate;
        private String boardingTime;
        private String bookerName;
        private String cellPhoneNumber;
        private Integer sumPrice;
        private String paymentMethod;
        private Course course;

        public Booking toBookingEntity(Tourist tourist, Course course) {
            log.info(this.toString());
            return Booking.builder()
                    .id(courseId)
                    .adultPersonnel(adultPersonnel)
                    .childPersonnel(childPersonnel)
                    .bookingDate(bookingDate)
                    .boardingTime(boardingTime)
                    .bookerName(bookerName)
                    .cellPhoneNumber(cellPhoneNumber)
                    .sumPrice(sumPrice)
                    .paymentMethod(paymentMethod)
                    .tourist(tourist)
                    .course(course)
                    .build();
        }
    }

}

