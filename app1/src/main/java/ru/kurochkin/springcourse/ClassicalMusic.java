package ru.kurochkin.springcourse;

import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Music {
//  паттерн  Фабричный метод
    private ClassicalMusic(){} //ограничение создания объекта через new, нужно использовать фабричный метод

    public static ClassicalMusic getClassicalMusic(){
        return new ClassicalMusic();
    }

    public void doMyInit(){
        System.out.println("Doing my initialization");
    }

    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
