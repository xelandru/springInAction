package chapter4.concert;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc("Sgt Pepper's Lonley Hearts CLub Band", "The Beatles");

        List<String> tracks = new ArrayList<>();

        tracks.add("Sgt Pepper's Lonley Hearts CLub Band");
        tracks.add("With a little help from my friends");
        tracks.add("Lucy in the sky with diamonds");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");

        cd.setTracks(tracks);

        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
