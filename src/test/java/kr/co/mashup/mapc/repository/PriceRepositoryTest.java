package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.DataJpaTestContext;
import kr.co.mashup.mapc.entity.Company;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.Price;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ethan.kim on 2018. 9. 2..
 */
public class PriceRepositoryTest extends DataJpaTestContext {

    @Autowired
    private PriceRepository sut;

    @Before
    public void setUp() throws Exception {
        Company company = Company.builder()
                .name("(주)허니문 여행사")
                .build();
        testEntityManager.persistAndFlush(company);

        Course course = Course.builder()
                .title("A코스")
                .subTitle("도심, 고궁코스")
                .mainColor("#fd7674")
                .subColor("#0cfd7674")
                .iconUrl("https://assets-cdn.github.com/images/modules/site/integrators/travis-ci.png")
                .description("도심, 고궁, 남산코스는 총 22곳의 정류장을 순환하며 원하는 정류장에서<br>하차하여 자유관람 30분 간격으로 다음 버스를 이용할 수 있습니다.<br>" +
                        "<font color=\"#fd7674\">(예약상황에 따라 배차간격이 25분~40분 간격으로 운행됩니다.)</font>")
                .company(company)
                .build();
        testEntityManager.persistAndFlush(course);

        Price price = Price.builder()
                .course(course)
                .passengerType(Price.PassengerType.ADULT)
                .price(18000)
                .build();
        sut.save(price);
    }

    @After
    public void tearDown() throws Exception {
        sut.deleteAll();
    }

    @Test
    public void 가격_리스트_조회시_정상적으로_조회된다() throws Exception {
        // given :

        // when :
        List<Price> prices = sut.findAll();

        // then :
        assertThat(prices).isNotEmpty();
    }
}