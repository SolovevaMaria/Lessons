package com.example.workdb.entities.OneToOne.second;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;


    @OneToOne
    @JoinColumn(name = "profile_id",referencedColumnName = "id")
    private Profile  profile;

    public Long getId() {

    }

    public String getFirstName() {
    }

    public String getLastName() {
        return null;
    }

    public Integer getAge() {
    }

    public String getEmail() {
        return null;
    }
}
