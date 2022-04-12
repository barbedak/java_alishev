package ru.kurochkin.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private Music music;
    private String name;
    private int volume;

    //DI Annotation
    //@Autowired
    //Spring сканирует все классы с @Component и создает бины
    //Сканирует все бины и подбирает подходящие к помеченному @Autowired по типу (класс или интерфейс)
    //можно аннотацию вешать на поля (даже приватное через Java Reflection API), сеттеры и конструкторы
    //можно внедрять бины по классу
    // public MusicalPlayer(ClassicalMusic classicalMusic){}
    // или по интерфейсу
    // public MusicalPlayer(Music music){}
    //Если два бина подходят по типу - то возникает неоднозначность


    public MusicPlayer(Music music) {
        this.music = music;
    }

    @Autowired
    public void setMusic(Music music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println("Playing: " + music.getSong());
    }
}
