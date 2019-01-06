package chapter2.javaconfig.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CDPlayerConfig {

    @Bean
    CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    CDPlayer cdPlayer() {
        return new CDPlayer(sgtPeppers());
    }


    @Bean
    MediaPlayer player() {
        return cdPlayer();
    }

}
