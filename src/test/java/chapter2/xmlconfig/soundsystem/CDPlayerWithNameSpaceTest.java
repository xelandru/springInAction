package chapter2.xmlconfig.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("cd-namespace-context.xml")
public class CDPlayerWithNameSpaceTest {

    @Autowired
    CompactDisc cdSgtPeppers;

    @Autowired
    CompactDisc cdAbbeyRoad;

    @Autowired
    CDPlayer cdPlayer1;

    @Autowired
    CDPlayer cdPlayer2;

    @Test
    public void CompactDiscNotNull(){
        assertNotNull(cdAbbeyRoad);
        assertNotNull(cdSgtPeppers);
    }

    @Test
    public void cdPlayerNotNull() {
        assertNotNull(cdPlayer1);
        assertNotNull(cdPlayer2);
    }

    @Test
    public void cdFromPlayerIsTheSameAsOutside() {
        assertSame(cdPlayer1.getCompactDisc(), cdSgtPeppers);
        assertSame(cdPlayer2.getCompactDisc(), cdAbbeyRoad);

        cdPlayer2.play();
    }
}