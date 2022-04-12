package ru.kurochkin.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //получаем bean из Application Context
        //указываем id bean и класс, bean которого хотим получить

        Music music = context.getBean("musicBean", Music.class);
        Music music2 = context.getBean("classicalMusic", Music.class);
        List<Music> musicList = new ArrayList<>();
        musicList.add(music);
        musicList.add(music2);
        MusicPlayer musicPlayer = new MusicPlayer(musicList);

        musicPlayer.playMusic();

        context.close(); //не забываем закрывать, при завершении работы с Application Context
    }
}
