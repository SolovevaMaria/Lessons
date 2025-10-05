package com.example.workdb.entities.OneToMany.second;

import jakarta.persistence.*;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String firstName;
    String position;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
