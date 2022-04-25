//DAO (Data Access Object) - паттерн проектирования, когда отдельный класс занимается взаимодействием с БД
// для конкретной сущности
//обычно пишется SQL код для работы с БД

//CRUD - основные функции для работы с БД
//	CREATE
//	READ
//	UPDATE
//	DELETE

package ru.kurochkin.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.kurochkin.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    //блок инициализации
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
