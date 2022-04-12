package ru.kurochkin.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;

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

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public String playMusic() {
        return "Playing: " + classicalMusic.getSong();
    }
}
