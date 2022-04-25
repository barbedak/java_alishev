
//REST - паттерн проектирования web-приложений, описывает то, как посредствам протокола HTTP должен взаимоджейстовать
// клиент с сервером
//        4 операции с данными
//        Получение - GET
//        Добавление новых - POST
//        Изменение существующих - PATCH / PUT
//        Удаление - DELETE

/*
@ModelAttribute
может аннотировать метод и аргумент метода

Метод:
@ModelAttribute("headerMessage")
public String populateHeaderMessage(){
	return "Welcome to our website!"
}
В модель КАЖДОГО метода текущего контроллера добаляется пара ключ-значение -
"headerMessage" - "Welcome to our website!"
Используетсмя, когда пара ключ-значение нужна во всех методах контроллера
можно передавать объект
@ModelAttribute("messageObject")
public MessageObject populateHeaderMessage(){
	MessageObject messageObject = new MessageObject();
	messageObject.setSomeField("Hello!");
	return messageObject;
}

Аргументы метода:
@PostMapping()
public String create(@ModelAttribute("person") Person person){
	//Добавляем человека в БД
	return "successPage";
}
замена
@PostMapping()
public String create(@RequestParam("name") String name, @RequestParam("surname") String surname,
				@RequestParam("email") String email, Model model){
	Person person = new Person();
	person.setName(name);
	person.setSurname(surname);
	person.setEmail(email);
	//добаляем человека в БД
	model.addAttribute("person", person);
	return "successPage";
}
* */

package ru.kurochkin.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kurochkin.springcourse.dao.PersonDAO;
import ru.kurochkin.springcourse.models.Person;


@Controller
@RequestMapping("/people")
public class PeopleController {

//внедрение объекта DAO в контроллер. Рекомендуемый. Вместо @Autowired
    private PersonDAO personDAO;

    @Autowired
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

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }
    /*можно заменить на
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        return "people/new";
    }
    */

    @PostMapping()
    public String create(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/people"; //редирект на нужную страницу
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
