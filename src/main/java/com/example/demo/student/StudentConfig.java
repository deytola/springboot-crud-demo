package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student ade = new Student(
                    "Ade",
                    "a@b.c",
                    LocalDate.of(2003, Month.JULY, 1)
            );
            Student alex = new Student(
                    "Alex",
                    "b@c.d",
                    LocalDate.of(2001, Month.JULY, 1)
            );
            repository.saveAll(List.of(ade, alex));
        };
    }
}
