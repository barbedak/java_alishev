package ru.kurochkin.springcourse;

import org.springframework.stereotype.Component;

@Component("rockMusic") //можем указать id бина, по умолчанию id будет равным имени класса с маленькой буквы - rockMusic
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
