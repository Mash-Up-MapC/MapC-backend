package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.DataJpaTestContext;
import kr.co.mashup.mapc.entity.Booking;
import kr.co.mashup.mapc.entity.Company;
import kr.co.mashup.mapc.entity.Course;
import kr.co.mashup.mapc.entity.Tourist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ethan.kim on 2018. 9. 2..
 */
public class BookingRepositoryTest extends DataJpaTestContext {

    @Autowired
    private BookingRepository sut;

    @Before
    public void setUp() throws Exception {
        Tourist tourist = Tourist.builder()
                .uuid("FFFFFFFF-C917-212C-D958-11A94F3D97CA")
                .build();
        testEntityManager.persistAndFlush(tourist);

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

        Booking booking = Booking.builder()
                .tourist(tourist)
                .course(course)
                .bookerName("ethan kim")
                .bookerPassword("1234567890")
                .cellPhoneNumber("01012341234")
                .homePhoneNumber("021231234")
                .adultPersonnel(2)
                .childPersonnel(0)
                .bookingDate(new Date())
                .boardingTime("10:00 ~ 10:30")
                .boardingPlace("광화문")
                .sumPrice(36000)
                .paymentMethod("DEBIT_CARD")
                .build();
        sut.save(booking);
    }

    @After
    public void tearDown() throws Exception {
        sut.deleteAll();
    }

    @Test
    public void 예약_리스트_조회시_정상적으로_조회된다() throws Exception {
        // given :

        // when :
        List<Booking> bookings = sut.findAll();

        // then :
        assertThat(bookings).isNotEmpty();
    }
}