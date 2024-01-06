package com.example.listlibraryapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class ListLibraryApiApplication implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void run(String... args) throws Exception {
    }

    public static void main(String[] args) {
        SpringApplication.run(ListLibraryApiApplication.class, args);
    }

}
