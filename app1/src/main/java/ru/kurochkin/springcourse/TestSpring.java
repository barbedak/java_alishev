package ru.kurochkin.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        //было с XML
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        context.close(); //не забываем закрывать, при завершении работы с Application Context

        //стало с Java Config Class
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(SpringConfig.class);
        MusicPlayer musicPlayer1 = context1.getBean("musicPlayer", MusicPlayer.class);
        context1.close();

    }
}
