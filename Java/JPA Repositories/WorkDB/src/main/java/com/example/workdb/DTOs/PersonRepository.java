package com.example.workdb.DTOs;

import com.example.workdb.entities.OneToOne.second.Person;
import org.hibernate.query.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    // Методы для фильтрации
    Page<Person> findByAgeGreaterThan(int age, Pageable pageable);

    Page<Person> findByLastName(String lastName, Pageable pageable);

    Page<Person> findByEmailLike(String emailPattern, Pageable pageable);

    Page<Person> findByAgeBetween(int minAge, int maxAge, Pageable pageable);

    Page<Person> findByFirstName(String firstName, Pageable pageable);


    org.springframework.data.domain.Page<Person> findAll(Sort sort, org.springframework.data.domain.Pageable pageable);

    // 1. SELECT с LIKE
    @Query(
            value = "SELECT * FROM persons " +
                    "WHERE email LIKE '%@gmail.com'",
            nativeQuery = true
    )
    List<Person> findByEmailGmail();

    // 2. SELECT + JOIN
    @Query(
            value = "SELECT p.id, p.firstName, c.name AS cityName " +
                    "FROM persons p " +
                    "JOIN cities c ON p.city_id = c.id",
            nativeQuery = true
    )
    List<PersonWithCity> findPersonsWithCity();

    // Интерфейс для JOIN
    interface PersonWithCity {
        Long getId();
        String getFirstName();
        String getCityName();
    }

    // 3. SELECT + агрегаты
    @Query(
            value = "SELECT lastName, COUNT(*) as count " +
                    "FROM persons " +
                    "GROUP BY lastName " +
                    "ORDER BY count DESC",
            nativeQuery = true
    )
    List<LastNameCount> findLastNameCount();

    // Интерфейс для агрегатов
    interface LastNameCount {
        String getLastName();
        Long getCount();
    }

    // 4. Пагинация
    @Query(
            value = "SELECT * FROM persons " +
                    "ORDER BY id " +
                    "OFFSET :offset ROWS FETCH NEXT :size ROWS ONLY",
            nativeQuery = true
    )
    List<Person> findByOffset(
            @Param("offset") int offset,
            @Param("size") int size
    );

    // 5. UPDATE
    @Modifying
    @Query(
            value = "UPDATE persons " +
                    "SET age = age + :delta " +
                    "WHERE age < :maxAge",
            nativeQuery = true
    )
    int updateAge(
            @Param("delta") int delta,
            @Param("maxAge") int maxAge
    );

    // 6. DELETE
    @Modifying
    @Query(
            value = "DELETE FROM persons " +
                    "WHERE age < :age",
            nativeQuery = true
    )
    int deleteByAge(@Param("age") int age);

    // 7. INSERT
    @Modifying
    @Query(
            value = "INSERT INTO persons (firstName, lastName, age, email) " +
                    "VALUES (:firstName, :lastName, :age, :email)",
            nativeQuery = true
    )
    int insertPerson(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("age") int age,
            @Param("email") String email
    );

    // 8. EXEC без параметров
    @Query(
            value = "EXEC GetPersonsAbove10",
            nativeQuery = true
    )
    List<Person> findPersonsAbove10();

    // 9. EXEC с параметром
    @Query(
            value = "EXEC GetPersonsAboveAge :minAge",
            nativeQuery = true
    )
    List<Person> findPersonsAboveAge(
            @Param("minAge") int minAge
    );

}

