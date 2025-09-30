package com.example.workdb.entities;

import com.example.workdb.models.TypeUser;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "firstName", nullable = false, length = 100)
    private String firstName;
    @Column(name = "lastName", columnDefinition = "NVARCHAR(100)")
    private String lastName;
    @Column(name = "phone", unique = true)
    private String phone;


    //    @Size(max = 100)
    @Email
    private String email;

    @NotBlank(message = "nelzya null and \"     \"") //nelzya null and "     "
    @NotNull(message = "nelzya null")   // nelzya null
    @NotEmpty(message = "nelzys null and size ==0")  //nelzys null and size ==0
    private String text;

    //    @Min(0)
//    @Max(100)
//    @Size(min = 2, max = 20,message = "znacenie doljno bit ot 2 do 20")
    @Range(min = 0, max = 100, message = "ddddd")
    Integer age;

    {

    }


    @Temporal(TemporalType.DATE)
//    @Future(message = "bith date must be in the past")
//    @Past(message = "bith date must be in the past")
//    @PastOrPresent(message = "bith date must be in the past")
//    @FutureOrPresent(message = "bith date must be in the past")
    LocalDate birthDate;//date
    LocalDateTime birthDateTime;//datetime

    @CreationTimestamp
    LocalDate createdDate;

    @UpdateTimestamp
    LocalDate updateDate;

//    @Positive
//            @PositiveOrZero
//    @Negative
//    @NegativeOrZero
    int zero;
    @Enumerated(EnumType.STRING)
    TypeUser typeUser;

    @Transient
    String java;


    //+994xxxxxxxxxx ili 0xxxxxxxx
//    @Pattern(regexp = "(\\+994[0-9]{9})|(0[0-9]{8,9})" ,message = "Card number must be valid"),


            @Pattern.List({
                    @Pattern(regexp = "(\\+994[0-9]{9})|(0[0-9]{8,9})" ,message = "Card number must be valid"),
                    @Pattern(regexp = "(\\+994[0-9]{9})|(0[0-9]{8,9})" ,message = "Card number must be valid"),
                    @Pattern(regexp = "(\\+994[0-9]{9})|(0[0-9]{8,9})" ,message = "Card number must be valid"),
                    @Pattern(regexp = "(\\+994[0-9]{9})|(0[0-9]{8,9})" ,message = "Card number must be valid")
            })
    String phoneAdd;
}


