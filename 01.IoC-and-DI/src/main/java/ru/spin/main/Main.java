package main.java.ru.spin.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        //Music music = context.getBean("musicBean", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(music);

        ElectroMusic em1 = context.getBean("musicBean01", ElectroMusic.class);
        ElectroMusic em2 = context.getBean("musicBean01", ElectroMusic.class);

        em1.setSinger("Singer 1");
        em2.setSinger("Singer 2");
        System.out.println(em1.getSinger() + " " + em2.getSinger());

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);

        musicPlayer.playMusicList();
        musicPlayer.setVolume(10);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        context.close();
    }
}
