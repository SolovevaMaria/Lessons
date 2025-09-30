package com.example.workdb.DTOs;

import com.example.workdb.entities.OneToOne.second.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // 1. Получить все записи с сортировкой по firstName по возрастанию.
    public Page<PersonDTO> findAllSortedByFirstName(Pageable pageable) {
        Page<Person> persons = personRepository.findAll(Sort.by("firstName").ascending(), pageable);
        return convertToDTOPage(persons);
    }

    // 2. Получить все записи с сортировкой по age по убыванию.
    public Page<PersonDTO> findAllSortedByAgeDesc(Pageable pageable) {
        Page<Person> persons = personRepository.findAll(Sort.by("age").descending(), pageable);
        return convertToDTOPage(persons);
    }

    // 3. Вернуть первую страницу (по 5 элементов) с сортировкой по id.
    public Page<PersonDTO> findFirstPageSortedById(Pageable pageable) {
        Pageable customPageable = PageRequest.of(0, 5, Sort.by("id"));
        Page<Person> persons = personRepository.findAll(customPageable);
        return convertToDTOPage(persons);
    }

    // 4. Вернуть вторую страницу (по 10 элементов) с сортировкой по lastName.
    public Page<PersonDTO> findSecondPageSortedByLastName(Pageable pageable) {
        Pageable customPageable = PageRequest.of(1, 10, Sort.by("lastName"));
        Page<Person> persons = personRepository.findAll(customPageable);
        return convertToDTOPage(persons);
    }

    // 5. Найти записи Person, у которых возраст больше 18 лет, с пагинацией.
    public Page<PersonDTO> findAdults(int age, Pageable pageable) {
        Page<Person> persons = (Page<Person>) personRepository.findByAgeGreaterThan(age, (java.awt.print.Pageable) pageable);
        return convertToDTOPage(persons);
    }

    // 6.Найти записи Person по lastName, возвращая только первую страницу.
    public Page<PersonDTO> findByLastName(String lastName, Pageable pageable) {
        Pageable customPageable = PageRequest.of(0, 10);
        Page<Person> persons = (Page<Person>) personRepository.findByLastName(lastName, (java.awt.print.Pageable) customPageable);
        return convertToDTOPage(persons);
    }

    // 7. Реализовать метод, который возвращает все записи с несколькими сортировками (по age и lastName).
    public Page<PersonDTO> findAllSortedByAgeAndLastName(Pageable pageable) {
        Sort sort = Sort.by("age").descending().and(Sort.by("lastName").ascending());
        Page<Person> persons = personRepository.findAll(sort, pageable);
        return convertToDTOPage(persons);
    }

    // 8. Получить записи с фильтром email LIKE %gmail.com и пагинацией
    public Page<PersonDTO> findByEmailGmail(String emailPattern, Pageable pageable) {
        // Добавляем шаблон поиска с % для LIKE
        String pattern = "%" + emailPattern + "%";

        // Получаем страницу с отфильтрованными записями
        Page<Person> persons = (Page<Person>) personRepository.findByEmailLike(pattern, (java.awt.print.Pageable) pageable);

        // Преобразуем в DTO
        return convertToDTOPage(persons);
    }


    // 9. Найти записи в возрастном диапазоне (от 20 до 40) с постраничной выборкой.
    public Page<PersonDTO> findByAgeRange(int minAge, int maxAge, Pageable pageable) {
        Page<Person> persons = (Page<Person>) personRepository.findByAgeBetween(minAge, maxAge, (java.awt.print.Pageable) pageable);
        return convertToDTOPage(persons);
    }

    // 10. Реализовать поиск Person по имени с сортировкой и пагинацией одновременно.
    public Page<PersonDTO> findByNameWithSorting(String firstName, Pageable pageable) {
        Page<Person> persons = (Page<Person>) personRepository.findByFirstName(firstName, (java.awt.print.Pageable) pageable);
        return convertToDTOPage(persons);
    }

    // Метод для преобразования Page<Person> в Page<PersonDTO>
    private Page<PersonDTO> convertToDTOPage(Page<Person> page) {
        List<PersonDTO> dtoList = new ArrayList<>();

        for (Person person : page.getContent()) {
            PersonDTO dto = new PersonDTO(
                    person.getId(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getAge(),
                    person.getEmail()
            );
            dtoList.add(dto);
        }

        return new PageImpl<>(
                dtoList,
                page.getPageable(),
                page.getTotalElements()
        );
    }



}
