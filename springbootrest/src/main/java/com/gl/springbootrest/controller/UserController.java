package com.gl.springbootrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/users")
    public String getUsers() {
        String sqlInsertQuery = "INSERT INTO user (name, email) VALUES (?, ?)";

        for (int counter = 1; counter < 5; counter++) {
            String name = "User" + counter;
            String email = "User" + counter + "@ab.in";
            jdbcTemplate.update(sqlInsertQuery, name, email);
        }

        return "List of users";
    }
}
