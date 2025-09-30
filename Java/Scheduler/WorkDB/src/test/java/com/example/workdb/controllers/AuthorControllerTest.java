package com.example.workdb.controllers;


import com.example.workdb.entities.Author;
import com.example.workdb.repositories.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorControllerTest { //implements MethodOrderer{

    @Autowired
    private AuthorRepository authorRepository;



    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Faker faker;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void cratate_author_valid_data_return_author() throws Exception {
        Author author = new Author();
        author.setEmail(faker.internet().emailAddress());
        author.setName(faker.name().firstName());
        author.setSurname(faker.name().lastName());
        mockMvc.perform(
                        post("/api/author")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(author)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(author.getEmail())))
                .andExpect(jsonPath("$.name", is(author.getName())))
                .andExpect(jsonPath("$.surname", is(author.getSurname())));
    }

    @Test
    @Order(2)
    public void get_author_existing_id_return_author() throws Exception {
        Author author = new Author();
        author.setEmail(faker.internet().emailAddress());
        author.setName(faker.name().firstName());
        author.setSurname(faker.name().lastName());

        Author result = authorRepository.save(author);
        mockMvc.perform(
                        get("/api/author/{id}", author.getId())
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(author)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(result.getEmail())))
                .andExpect(jsonPath("$.name", is(result.getName())))
                .andExpect(jsonPath("$.id").value(result.getId()))
                .andExpect(jsonPath("$.surname", is(result.getSurname())));
    }

    @Test
    @Order(4)
    public void get_author_not_existing_id_return_author() throws Exception {
        mockMvc.perform(get("/api/author/{id}", -1))
                .andExpect(status().isNotFound());
    }


    private void add_100_000_authors() {
       if (authorRepository.count()<100_000){
           List<Author> authors = new ArrayList<>();

           for (int i = 0; i < 100_000; i++) {
               String email = faker.internet().emailAddress();
               String name = faker.name().firstName();
               String surname = faker.name().lastName();

               authors.add(new Author(email, name, surname));
           }

           authorRepository.saveAll(authors);
       }
    }

    @Test
    @Order(3)
    public void get_all_author_return_authors() throws Exception {
        add_100_000_authors();

        mockMvc.perform(get("/api/author"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(100_000))));
    }

    @Test
    @Order(5)
    public void get_empty_authors_return_not_content() throws Exception {
        authorRepository.deleteAll();

        mockMvc.perform(get("/api/author"))
                .andExpect(status().isNoContent());
    }


    @Test
    @Order(6)
    public void delete_author_existing_id_return_ok() throws Exception {
        Author author = new Author();
        author.setEmail(faker.internet().emailAddress());
        author.setName(faker.name().firstName());
        author.setSurname(faker.name().lastName());

        Author result = authorRepository.save(author);

        mockMvc.perform(
                        delete("/api/author/{id}", result.getId()))
                .andExpect(status().isOk());
    }


    @Test
    @Order(7)
    public void delete_author_not_existing_id_return_not_fount() throws Exception {
        mockMvc.perform(
                        delete("/api/author/{id}", -1))
                .andExpect(status().isNotFound());
    }


//    @Override
//    public void orderMethods(MethodOrdererContext context) {
//        context.getMethodDescriptors().sort(x);
//    }
}


