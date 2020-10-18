package com.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    private final StudentService studentService;

    @Autowired
    public Main(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            studentService.newStudent();
            studentService.displayStudent();
        };
    }
}
