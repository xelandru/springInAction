package chapter2.xmlconfig.soundsystem;


class CDPlayer implements MediaPlayer {

    private CompactDisc compactDisc;

     CDPlayer(CompactDisc compactDisc) {
        this.compactDisc = compactDisc;
    }

    public CompactDisc getCompactDisc() {
        return compactDisc;
    }

    @Override
    public void play() {
        compactDisc.play();
    }
}
