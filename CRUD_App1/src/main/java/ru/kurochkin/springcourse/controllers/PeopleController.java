
//REST - паттерн проектирования web-приложений, описывает то, как посредствам протокола HTTP должен взаимоджейстовать
// клиент с сервером
//        4 операции с данными
//        Получение - GET
//        Добавление новых - POST
//        Изменение существующих - PATCH / PUT
//        Удаление - DELETE

package ru.kurochkin.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kurochkin.springcourse.dao.PersonDAO;


@Controller
@RequestMapping("/people")
public class PeopleController {

//внедрение объекта DAO в контроллер. Рекомендуемый. Вместо @Autowired
    private PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        //Получим всех людей из DAO и передадим в представление
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        //получим одного человека из DAO по id
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}
