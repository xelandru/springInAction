package chapter2.xmlconfig.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("c-context.xml")
public class CDPlayerTest {

    @Autowired
    CompactDisc cd;

    @Autowired
    CDPlayer cdPlayer;

    @Test
    public void CompactDiscNotNull(){
        assertNotNull(cd);
    }

    @Test
    public void cdPlayerNotNull() {
        assertNotNull(cdPlayer);
    }

    @Test
    public void cdPlayerHasCD() {
        assertNotNull(cdPlayer.getCd());
        assertSame(cd, cdPlayer.getCd());
    }
}