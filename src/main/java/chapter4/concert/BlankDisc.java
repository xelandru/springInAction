package chapter2.xmlconfig.soundsystem;


import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    List<String> tracks;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }

    public void setTracks(List<String> tracks) {

        this.tracks = tracks;
    }
}