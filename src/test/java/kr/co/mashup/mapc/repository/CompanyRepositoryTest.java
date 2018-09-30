package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.DataJpaTestContext;
import kr.co.mashup.mapc.entity.Company;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ethan.kim on 2018. 9. 1..
 */
public class CompanyRepositoryTest extends DataJpaTestContext {

    @Autowired
    private CompanyRepository sut;

    @Before
    public void setUp() throws Exception {
        Company company = Company.builder()
                .name("(주)허니문 여행사")
                .build();
        sut.save(company);
    }

    @After
    public void tearDown() throws Exception {
        sut.deleteAll();
    }

    @Test
    public void 회사_리스트_조회시_정상적으로_조회된다() throws Exception {
        // given :

        // when :
        List<Company> companies = sut.findAll();

        // then :
        assertThat(companies).isNotEmpty();
    }
}
