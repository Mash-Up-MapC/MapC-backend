package kr.co.mashup.mapc.dto;

import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.Price;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

public class CoursesDto {

    @Data //lombok getter setter가 적용된다.
    @ToString //해당 클래스의 toString() 메소드 적용
    @Slf4j //로깅퍼사드(로그 인터페이스) 객체가 생성될때마다 로깅
    //스태틱으로 선언함으로써 CourseDto를 선언하지 않고도 CourseSelection 이용가능
    public static class CourseSelection {
        private long id;
        private String type;
        private String name;
        private List<String> price;
        private String main_color;
        private String sub_color;
        private String icon;

        public CourseSelection(Course entity) {
            //"성인(Type) 18,000원(price)" 하나로 처리하기 위해
            List<Price> prices = entity.getPrices();
            StringBuilder tmp;
            this.id = entity.getId();
            this.type = entity.getTitle();
            this.name = entity.getSubTitle();
            price = new ArrayList<>();
            this.main_color = entity.getMainColor();
            this.sub_color = entity.getSubColor();
            this.icon = entity.getIconUrl();

            //pirce 하나로 처리 하기위한 컨버터
            for (int i = 0; i < prices.size(); i++) {
                tmp = new StringBuilder();
                tmp.append(prices.get(i).getPassengerType())
                        .append(" ")
                        .append(prices.get(i).getPrice())
                        .append("원");
                price.add(tmp.toString());
            }


        }
    }
}
