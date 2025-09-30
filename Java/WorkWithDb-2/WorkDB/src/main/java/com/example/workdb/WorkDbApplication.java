package com.example.workdb;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import java.math.BigDecimal;
import java.util.Date;
@SpringBootApplication
public class WorkDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkDbApplication.class, args);
        @Entity
        @Table(name = "Departments")
        class Department {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;

            @Column(nullable = false)
            private BigDecimal financing;

            @Column(nullable = false, unique = true)
            private String name;
            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }


            public BigDecimal getFinancing() {
                return financing;
            }

            public void setFinancing(BigDecimal financing) {
                this.financing = financing;
            }


            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

        }

        @Entity
        @Table(name = "Faculties")
        class Faculty {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;

            @Column(nullable = false)
            private String dean;

            @Column(nullable = false, unique = true)
            private String name;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getDean() {
                return dean;
            }

            public void setDean(String dean) {
                this.dean = dean;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        @Entity
        @Table(name = "Groups")
        class Group {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;

            @Column(nullable = false, unique = true)
            @NotNull
            @NotEmpty
            @Size(max = 10)
            private String name;

            @Column(nullable = false)
            @Min(0)
            @Max(5)
            private Integer rating;

            @Column(nullable = false)
            @Min(1)
            @Max(5)
            private Integer year;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getRating() {
                return rating;
            }

            public void setRating(Integer rating) {
                this.rating = rating;
            }

            public Integer getYear() {
                return year;
            }

            public void setYear(Integer year) {
                this.year = year;
            }
        }

        @Entity
        @Table(name = "Teachers")
        class Teacher {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;

            @Column(nullable = false)
            private Date employmentDate;

            @Column(nullable = false)
            private Boolean isAssistant;

            @Column(nullable = false)
            private Boolean isProfessor;

            @Column(nullable = false)
            private String name;

            @Column(nullable = false)
            private String position;

            @Column(nullable = false)
            private BigDecimal premium;

            @Column(nullable = false)
            private BigDecimal salary;

            @Column(nullable = false)
            private String surname;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Date getEmploymentDate() {
                return employmentDate;
            }

            public void setEmploymentDate(Date employmentDate) {
                this.employmentDate = employmentDate;
            }

            public Boolean getIsAssistant() {
                return isAssistant;
            }

            public void setIsAssistant(Boolean isAssistant) {
                this.isAssistant = isAssistant;
            }

            public Boolean getIsProfessor() {
                return isProfessor;
            }

            public void setIsProfessor(Boolean isProfessor) {
                this.isProfessor = isProfessor;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public BigDecimal getPremium() {
                return premium;
            }

            public void setPremium(BigDecimal premium) {
                this.premium = premium;
            }

            public BigDecimal getSalary() {
                return salary;
            }

            public void setSalary(BigDecimal salary) {
                this.salary = salary;
            }

            public String getSurname() {
                return surname;
            }

            public void setSurname(String surname) {
                this.surname = surname;
            }
        }
    }

}


