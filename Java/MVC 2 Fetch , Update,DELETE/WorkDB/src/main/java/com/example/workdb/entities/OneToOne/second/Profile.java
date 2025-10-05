package com.example.workdb.entities.OneToOne.second;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String avatarUrl;

    @OneToOne(mappedBy = "profile")
    private Person  person;
}
