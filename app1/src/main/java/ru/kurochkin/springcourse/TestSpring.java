package ru.kurochkin.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //получаем bean из Application Context
        //указываем id bean и класс, bean которого хотим получить
        Music music = context.getBean("musicBean", Music.class);

        MusicPlayer musicPlayer = new MusicPlayer(music);
        musicPlayer.playMusic();

        context.close(); //не забываем закрывать, при завершении работы с Application Context
    }
}
