package ru.kurochkin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first") //url должен заканчиваться на /first. Префикс для адресов методов этого класса
public class FirstController {

    @GetMapping("/hello") // реальный адрес /first/hello
    public String helloPage(){
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
