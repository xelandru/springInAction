package chapter2.javaconfig.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {


    @Autowired
    private CDPlayerConfig config;


    @Rule
    public final SystemOutRule rule = new SystemOutRule().enableLog();

    @Test
    public void sgtPeppersShouldBeNotNUll() {

        assertNotNull(config.sgtPeppers());
    }

    @Test
    public void cdPlayerShouldBeNotNull() {
        assertNotNull(config.cdPlayer());
    }

    @Test
    public void cdPlayerHasSameCDInIt() {
        assertSame(config.cdPlayer(), config.cdPlayer());
    }

    @Test
    public void play() {

        config.player().play();
        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band" +
                        " by The Beatles\n",
                rule.getLog());
    }
}