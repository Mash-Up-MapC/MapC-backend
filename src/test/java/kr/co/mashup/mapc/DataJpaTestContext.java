package kr.co.mashup.mapc;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ethan.kim on 2018. 9. 2..
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DataJpaTestContext {

    @Autowired
    protected TestEntityManager testEntityManager;
}
