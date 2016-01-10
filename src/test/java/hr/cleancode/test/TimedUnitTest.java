package hr.cleancode.test;

import hr.cleancode.config.MyConfiguration;
import hr.cleancode.service.SimpleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Test as an example.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class TimedUnitTest {

    @Autowired
    SimpleService simpleService;

    @Test
    public void testPerformOperation() {
        simpleService.performServiceOperation();
    }
}
