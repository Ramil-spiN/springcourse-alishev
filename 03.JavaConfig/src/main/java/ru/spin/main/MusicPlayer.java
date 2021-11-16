package ru.spin.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
    //@Autowired
    private List<Music> musicList;

    //IoC
    @Autowired //Внедрение зависимости через поле / конструктор / сеттер с любым именем
    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

   /* @Autowired
    @Qualifier("rockNRollMusic")
    public void setMusic(Music music) {
        this.music = music;
    }*/

    public MusicPlayer() {}

    public void doInit() {
        System.out.println("Player Initialization");
    }

    public void doDestroy() {
        System.out.println("Player Destruction");
    }

    public String playMusic() {
        String song = "No such song";
        Random random = new Random();
        Music genre = musicList.get(random.nextInt(musicList.size()));
        song = genre.getSong(random.nextInt(genre.getSongsCount()));
        return "Playing: " + genre.getClass().getSimpleName() + " - " + song;
    }
}
