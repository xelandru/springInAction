package chapter2.autoconfig.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CDPlayer implements MediaPlayer {

    private CompactDisc cd;


    @Autowired
    CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired

    void setCd(CompactDisc cd) {
        this.cd = cd;
    }


    @Override
    public void play() {
        cd.play();
    }
}
