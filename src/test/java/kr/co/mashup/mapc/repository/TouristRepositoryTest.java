package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.DataJpaTestContext;
import kr.co.mashup.mapc.entity.Tourist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ethan.kim on 2018. 9. 1..
 */
public class TouristRepositoryTest extends DataJpaTestContext {

    @Autowired
    private TouristRepository sut;

    @Before
    public void setUp() throws Exception {
        Tourist tourist = Tourist.builder()
                .uuid("FFFFFFFF-C917-212C-D958-11A94F3D97CA")
                .build();
        sut.save(tourist);
    }

    @After
    public void tearDown() throws Exception {
        sut.deleteAll();
    }

    @Test
    public void 관광객_리스트_조회시_정상적으로_조회된다() throws Exception {
        // given :

        // when :
        List<Tourist> tourists = sut.findAll();

        // then :
        assertThat(tourists).isNotEmpty();
    }
}
