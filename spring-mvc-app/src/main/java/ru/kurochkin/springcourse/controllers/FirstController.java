package ru.kurochkin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model){
        System.out.println("Goodbye, " + name + " " + surname);
        model.addAttribute("message","Goodbye, " + name + " " + surname);
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam ("a") int a, @RequestParam("b") int b,
                                 @RequestParam("action") String action, Model model){
        double result = 0;
        if (action.equals("multiplication")){
            result = a * b;
        }
        if (action.equals("addition")){
            result = a + b;
        }
        if (action.equals("subtraction")){
            result = a - b;
        }
        if (action.equals("division") && b!=0){
            result = a / (double)b;
        }
        model.addAttribute("action", action);
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
