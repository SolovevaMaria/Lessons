package com.example.workdb.entities.OneToOne.first;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "firstName")
    private String firstName;

     @OneToOne
     @JoinColumn(name = "workstation_id",referencedColumnName = "id")
     private Workstation workstation;
}
