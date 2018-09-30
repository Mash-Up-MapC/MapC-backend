package kr.co.mashup.mapc.dto;

import kr.co.mashup.mapc.entity.*;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
//modelmapper추가하

@Data
@ToString
@Slf4j
public class DetailCourseDto {


    private long id;
    private List<String> img;
    private String type;
    private String name;
    private String price;
    private String operating_time;
    private String description;
    private List<TouristDestination> tourist_destinaion;
//    private List<Route> route; 추후 코스 루트 api 추가시 적용
    private List<TouristAttractions> tourist_attractions;
    private int page;//페이징처리?

    public void convertToDto(Course course) {
        List<Price> prices = course.getPrices();
        List<Station> stations = course.getStations();
        StringBuilder tmp = new StringBuilder();
        int priceSize = prices.size();

        this.id = course.getId();
        this.type = course.getTitle();
        this.name = course.getSubTitle();
        this.description = course.getDescription();
        this.page = 1;//페이징처리?
        this.tourist_attractions = new ArrayList<>();
        this.tourist_destinaion = new ArrayList<>();
        this.img = new ArrayList<>();

        for(int i = 0; i < priceSize; i++) {
            tmp.append(prices.get(i).getPassengerType())
                    .append(" ")
                    .append(prices.get(i).getPrice())
                    .append("원");

            if((prices.size()-1) != i) {
                tmp.append(" / ");
            }
        }

        this.price = tmp.toString();

        for(CourseOption courseOption : course.getCourseOptions()) {
            if(courseOption.getOptionType().equals("PRECAUTIONS")){
                this.operating_time = courseOption.getOptionValue();
            }
        }

        for(CourseImage courseImageimg : course.getCourseImages()) {
         this.img.add(courseImageimg.getImageUrl());
        }

        for(int i = 0; i < 3; i++) {
            TouristDestination tdTmp = TouristDestination.
                    builder().
                    name(stations.get(i).getName()).
                    img("https://s3.ap-northeast-2.amazonaws.com/key-s3/mapc/%E1%84%80%E1%85%AA%E1%86%BC%E1%84%92%E1%85%AA%E1%84%86%E1%85%AE%E1%86%AB1.JPG").
                    build();
//            tTmp.setImg(stations.get(i).getStationImages().get(0).getImageUrl());
            tourist_destinaion.add(tdTmp);
        }

        for(int i = 0; i < 3; i++) {
            TouristAttractions taTmp = TouristAttractions.
                    builder().
                    name(stations.get(i).getName()).
                    img("https://s3.ap-northeast-2.amazonaws.com/key-s3/mapc/%E1%84%80%E1%85%AA%E1%86%BC%E1%84%92%E1%85%AA%E1%84%86%E1%85%AE%E1%86%AB1.JPG").
                    description(stations.get(i).getDescription()).
                    build();
//            tTmp.setImg(stations.get(i).getStationImages().get(0).getImageUrl());
            tourist_attractions.add(taTmp);
        }
    }


}
