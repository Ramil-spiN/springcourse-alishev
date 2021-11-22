package ru.spin.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.spin.spring.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("select * from person order by id", new PersonMapper());
        //Можно не создавать свой маппер, а использовать BeanPropertyRowMapper
    }

    public Person show(int id) {
        return jdbcTemplate.query("select * from person where id=?", new BeanPropertyRowMapper<>(Person.class), id)
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("insert into person values (default, ? , ? , ?)",
                person.getName(), person.getAge(), person.getEmail());
    }

    public void update(Person person) {
        jdbcTemplate.update("update person set name=?, age=?, email=? where id=?",
                person.getName(), person.getAge(), person.getEmail(), person.getId());
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from person where id=?", id);
    }
}
