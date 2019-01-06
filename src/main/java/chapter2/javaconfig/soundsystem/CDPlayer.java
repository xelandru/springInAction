package chapter2.javaconfig.soundsystem;

class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
