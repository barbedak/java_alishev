//DAO (Data Access Object) - паттерн проектирования, когда отдельный класс занимается взаимодействием с БД
// для конкретной сущности
//обычно пишется SQL код для работы с БД

//CRUD - основные функции для работы с БД
//	CREATE
//	READ
//	UPDATE
//	DELETE

package ru.kurochkin.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.kurochkin.springcourse.models.Person;

import java.sql.*;
import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        // row mapper(PersonMapper) отображает строки из таблицы в сущности
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public Person show(int id) {
        // new BeanPropertyRowMapper<>(Person.class)) сопостовляет поля объекта колонкам результата выполнения запроса,
        // с таким же названием
        // jdbc template использует по умолчанию PreparedStatement
        // .stream().findAny().orElse(null); - если в списке есть хотя бы один объект, то он будет возвращен, иначе - null
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person VALUES(1,?,?,?)", person.getName(), person.getAge(),
                person.getEmail());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?", updatedPerson.getName(),
                updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
