package ru.kurochkin.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    private Music music1;
    private Music music2;

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
    //@Qualifier("rockMusic") - "уточнитель", указываем id бина, который необходимо внедрить
    //Используется на полях, конструкторах и сеттерах
    //НО!
    //@Autowired
    //public MusicPlayer(@Qualifier("rockMusic") Music music1,
    //                   @Qualifier("classicalMusic") Music music2) {
    //  this.music1 - music1;
    //  this.music2 = music2;
    //  }

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic() {
        return "Playing: " + music1.getSong() + ", " + music2.getSong();
    }
}
