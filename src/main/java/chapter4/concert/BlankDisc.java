package chapter4.concert;


import java.util.List;

public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;

    List<String> tracks;

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {

        this.tracks = tracks;
    }

    @Override
    public void playTrack(int trackNumber) {

    }
}