package Controllers;

import models.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person")
 class PersonController {
    private List<Person> people = new ArrayList<>();
    private AtomicInteger idCounter = new AtomicInteger(1);

    public PersonController() {
        people.add(new Person(idCounter.getAndIncrement(), "Farid", "Abdullayev", 29));
        people.add(new Person(idCounter.getAndIncrement(), "Oleq", "Qazmanov", 74));
        people.add(new Person(idCounter.getAndIncrement(), "Dima", "Bilan", 48));
    }

    @GetMapping("/all")
    public List<Person> getAll() {
        return people;
    }



    @DeleteMapping("/{id}")
    public Person deleteById(@PathVariable int id) {
        Person p = people.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
        people.remove(p);
        return p;
    }

    @PutMapping("/{id}")
    public Person updateById(@PathVariable int id, @RequestBody Person person) {
        Person p = people.stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);

        if (p != null) {
            if (person.getAge() != 0) {
                p.setAge(person.getAge());
            }
            if (person.getSurname() != null) {
                p.setSurname(person.getSurname());
            }
            if (person.getName() != null) {
                p.setName(person.getName());
            }
        }
        return p;
    }

    // 1 Поиск по фамилии
    @GetMapping("/search")
    public List<Person> searchBySurname(@RequestParam String surname) {
        return people.stream()
                .filter(p -> p.getSurname().equalsIgnoreCase(surname))
                .collect(Collectors.toList());
    }

    // 2 Фильтрация по возрасту
    @GetMapping("/filter")
    public List<Person> filterByAge(@RequestParam int min, @RequestParam int max) {
        return people.stream()
                .filter(p -> p.getAge() >= min && p.getAge() <= max)
                .collect(Collectors.toList());
    }

    // 3 Сортировка
    @GetMapping("/sort")
    public List<Person> sort(@RequestParam String by, @RequestParam String dir) {
        Comparator<Person> comparator = switch (by.toLowerCase()) {
            case "name" -> Comparator.comparing(Person::getName);
            case "surname" -> Comparator.comparing(Person::getSurname);
            case "age" -> Comparator.comparingInt(Person::getAge);
            default -> Comparator.naturalOrder();
        };

        if ("desc".equalsIgnoreCase(dir)) {
            comparator = comparator.reversed();
        }

        return people.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 4 Валидация
    @PostMapping("/")
    public Boolean add(@RequestBody Person person) {
        if (person == null) {
            return false;
        }
        if (person.getName() == null || person.getName().trim().isEmpty()) {
            return false;
        }
        if (person.getSurname() == null || person.getSurname().trim().isEmpty()) {
            return false;
        }

        if (person.getAge() == null || person.getAge() <= 0) {
            return false;
        }
        person.setId(idCounter.getAndIncrement());
        return people.add(person);
    }

    // 5. Удаление по фамилии
    @DeleteMapping("/deleteBySurname")
    public int deleteBySurname(@RequestParam String surname) {
        long count = people.stream()
                .filter(p -> p.getSurname().equalsIgnoreCase(surname))
                .collect(Collectors.toList())
                .size();

        people.removeIf(p -> p.getSurname().equalsIgnoreCase(surname));
        return (int) count;
    }

    // 6. Самый молодой и самый старый
    @GetMapping("/youngest")
    public Person getYoungest() {
        return people.stream()
                .min(Comparator.comparingInt(Person::getAge))
                .orElse(null);
    }

    @GetMapping("/oldest")
    public Person getOldest() {
        return people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);
    }
    }
