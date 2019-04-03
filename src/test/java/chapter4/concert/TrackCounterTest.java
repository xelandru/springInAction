package chapter4.concert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class TrackCounterTest {


    @Rule
    public final SystemOutRule rule = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    TrackCounter counter;

    @Test
    public void testTrackCounter() {
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(7);
        cd.playTrack(7);

        assertEquals(1, counter.getPLayCount(1));
        assertEquals(1, counter.getPLayCount(2));
        assertEquals(4, counter.getPLayCount(3));
        assertEquals(2, counter.getPLayCount(7));
        assertEquals(0, counter.getPLayCount(5));

    }

}