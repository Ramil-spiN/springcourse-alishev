package ru.spin.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MusicPlayer {
    //@Autowired
    private Music music1;
    private Music music2;

    //IoC
    @Autowired //Внедрение зависимости через поле / конструктор / сеттер с любым именем
    public MusicPlayer(@Qualifier("electroMusic") Music music1, @Qualifier("rockNRollMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
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

    public String playMusic(MusicGenre musicGenre) {
        String song = "No such song";
        Random random = new Random();
        int num = random.nextInt(3);
        switch(musicGenre) {
            case ELECTRO:
                song = music1.getSong(num);
                break;
            case ROCKNROLL:
                song = music2.getSong(num);
                break;
        }
        //System.out.println(music.getSong());
        //return "Playing: " + music.getSong();
        return "Playing: " + song;
    }
}
