package ru.spin.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private MusicPlayer musicPlayer;

    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    //@Override
    public String toString(MusicGenre musicGenre) {
        return "Computer " +
                "id=" + id +
                ", " + musicPlayer.playMusic(musicGenre);
    }
}
