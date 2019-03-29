package chapter4.concert;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class ConcertConfigTest {


    @Rule
    public final SystemOutRule rule = new SystemOutRule().enableLog();

    @Autowired
    Performance performance;

    @Test
    public void test() {
        performance.perform();

        Assert.assertEquals("Silencing cell phones\n" +
                "Taking seats\n" +
                "Performing rock\n" +
                "CLAP CKAP CLAP !!!\n", rule.getLog());
    }
}