package kr.co.mashup.mapc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.mashup.mapc.dto.DetailCourse;
import kr.co.mashup.mapc.dto.TouristAttractions;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethan.kim on 2018. 8. 30..
 */
@RestController
@RequestMapping(path = "/courses/{course_Id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(description = "코스", tags = {"course"})
public class CourseController {

    private static final DetailCourse DETAIL_COURSE;
    static {
        TouristAttractions touristAttractions, touristAttractions2, touristAttractions3;
        String[] imgs = {"https://assets-cdn.github.com/images/modules/site/integrators/travis-ci.png",
                        "https://assets-cdn.github.com/images/modules/site/integrators/travis-ci.png",
                        "https://assets-cdn.github.com/images/modules/site/integrators/travis-ci.png"};
        List<TouristAttractions> list = new ArrayList<>();
        touristAttractions = TouristAttractions.builder()
                .name("광화문")
                .img("https://assets-cdn.github.com/images/modules/site/integrators/travis-ci.png")
                .description("조선 왕조의 정궁인 경복궁의 정문. 광화문 일대는 정부기관 뿐만 아니라 빌딩에 각종 기업 본사 등도 많이 입주해있는 서울의 대표적인 업무지구 중 한 곳이다.")
                .build();
        touristAttractions2 = TouristAttractions.builder()
                .name("이태원")
                .img("https://assets-cdn.github.com/images/modules/site/integrators/travis-ci.png")
                .description("덕수궁은 조선시대에 지어진 궁궐이다. 덕수궁 내에는 석조전, 덕수궁 국립현대미술관, 그리고 중명전 등의 아름다운 서양식 건물이 자리잡고 있다.")
                .build();
        touristAttractions3 = TouristAttractions.builder()
                .name("창덕궁")
                .img("https://assets-cdn.github.com/images/modules/site/integrators/travis-ci.png")
                .description("대한민국 최대 규모의 국립 박물관이다. 대한민국의 수많은 국보와 보물들을 관람할 수 있다. 2014년 10월에 개장한 국립한글박물관과 용산가족공원이 인근에 위치해 다양한 관광을 할 수 있다.")
                .build();

        list.add(touristAttractions);
        list.add(touristAttractions2);
        list.add(touristAttractions3);

        DETAIL_COURSE = DetailCourse.builder()
                .id(1L)
                .img(imgs)
                .type("A코스")
                .name("도심, 고궁코스")
                .price("성인 18,000원 / 학생(5세-고등학생) 12,000원")
                .operatingTime("첫차 오전 9시~막차 오후 6시 (운행시간 내, 광화문 출/도착 기준)")
                .description("도심, 고궁, 남산코스는 총 22곳의 정류장을 순환하며 원하는 정류장에서 하차하여 자유관람 30분 간격으로 다음 버스를 이용할 수 있습니다. <font>(예약상황에 따라 배차간격이 25분~40분 간격으로 운행됩니다.)</font>")
                .touristDesctination(list)
                .route(null)
                .touristAttractions(list)
                .build();
    }

    public CourseController() {
    }

    @ApiOperation(value = "코스 상세보기", notes = "코스 상세보기 한다")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "조회 성공")
    })
    @GetMapping
    public ResponseEntity<DetailCourse> getCourses(@PathVariable(value = "course_Id") String courseId) {
        return ResponseEntity.ok(DETAIL_COURSE);
    }
}

