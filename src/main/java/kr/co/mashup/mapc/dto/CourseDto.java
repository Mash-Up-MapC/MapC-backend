package kr.co.mashup.mapc.dto;

import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.Price;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


public class CourseDto {

    @Data
    @ToString
    @Slf4j
    public static class CourseSelection {
        private long id;
        private String courseName;
        private List<Integer> price;
        private List<Price.PassengerType> passengerType;

        public CourseSelection(Course entity) {
            this.id = entity.getCourseId();
            this.courseName = entity.getTitle();
            price = new ArrayList<>();
            for (Price p : entity.getPrices()) {
                price.add(p.getPrice());
            }
            passengerType = new ArrayList<>();
            for (Price pp : entity.getPrices()) {
                passengerType.add(pp.getPassengerType());
            }
        }
    }
}
