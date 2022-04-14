package ru.kurochkin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first") //url должен заканчиваться на /first. Префикс для адресов методов этого класса
public class FirstController {

    //Работа с параметрами GET-запроса
    //1 вариант HttpServletRequest. Возвращает ВЕСЬ запрос
    @GetMapping("/hello") // реальный адрес /first/hello
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    //2 вариант @RequestParam. Предпочтительнее
    //ждет параметры в URL, если их нет - возвращает ошибку
    //чтобы не было ошибки используется "required = false", помещающий null в переменную, если параметр не передавался
    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname){
        System.out.println("Goodbye, " + name + " " + surname);

        return "first/goodbye";
    }
}
