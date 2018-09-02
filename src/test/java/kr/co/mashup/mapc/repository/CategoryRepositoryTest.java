package kr.co.mashup.mapc.repository;

import kr.co.mashup.mapc.DataJpaTestContext;
import kr.co.mashup.mapc.entity.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by ethan.kim on 2018. 9. 2..
 */
public class CategoryRepositoryTest extends DataJpaTestContext {

    @Autowired
    private CategoryRepository sut;

    @Before
    public void setUp() throws Exception {
        Category category = Category.builder()
                .name("관련역사")
                .build();
        sut.save(category);
    }

    @After
    public void tearDown() throws Exception {
        sut.deleteAll();
    }

    @Test
    public void 카테고리_리스트_조회시_1개가_조회된다() throws Exception {
        // given :

        // when :
        List<Category> categories = sut.findAll();

        // then :
        assertThat(categories).hasSize(1);
    }
}