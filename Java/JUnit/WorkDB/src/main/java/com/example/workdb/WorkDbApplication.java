package com.example.workdb;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkDbApplication.class, args);
    }

    @Bean
    public Faker faker(){
        return new Faker();
    }
}
