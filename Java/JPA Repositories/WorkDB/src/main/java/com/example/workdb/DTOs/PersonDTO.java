package com.example.workdb.DTOs;

import com.example.workdb.entities.OneToOne.second.Person;
import com.example.workdb.entities.Teacher;

public class PersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;

    public PersonDTO(Long id, String firstName, String lastName,Integer age,String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public PersonDTO(Person person) {
        id = person.getId();
        firstName = person.getFirstName();
        lastName = person.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
