package ru.kurochkin.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") //указывает область видимости бина
public class ClassicalMusic implements Music {

    @PostConstruct //init-method
    public void doMyInit(){
        System.out.println("Doing my initialization");
    }

    @PreDestroy //destroy-method
    public void doMyDestroy(){
        System.out.println("Doing my destruction");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}
