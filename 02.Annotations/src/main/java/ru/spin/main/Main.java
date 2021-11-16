package ru.spin.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        //Music music = context.getBean("musicBean", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(music);
        //

        //MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        //System.out.println(musicPlayer.playMusic());

        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer.toString(MusicGenre.ROCKNROLL));

        System.out.println(computer.getName());
        System.out.println(computer.getVolume());

        context.close();
    }
}
