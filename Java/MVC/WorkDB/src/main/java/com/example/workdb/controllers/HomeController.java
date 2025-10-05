package com.example.workdb.controllers;

import com.example.workdb.entities.Teacher;
import com.example.workdb.models.Person;
import com.example.workdb.repositories.TeacherRepository;
//import com.example.workdb.services.TeacherServices;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//MVC (M-odal , V-iew , C-ontroller)
//Model        - soderjit klassi
//View         - za vizualizaciyu
//Controller   - obrabativaet zaprosi i obnovlyayet view

@Controller
@RequestMapping("/api/teacher")
public class HomeController {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private Faker faker;


    @GetMapping("/farid")
    public List<String> getAllFarid(
    ) {
//        return teacherRepository.skubidu("mo");
        return List.of("Hello World");
    }
    // Метод для получения списка с сортировкой
    @GetMapping("/list")
    public String hi(Model model,
                     @RequestParam(required = false) String sortBy,
                     @RequestParam(required = false, defaultValue = "asc") String direction) {

        model.addAttribute("title", "Home Page");

        // Добавляем сортировку
        if (sortBy != null) {
            Sort sort = direction.equalsIgnoreCase("asc") ?
                    Sort.by(sortBy).ascending() :
                    Sort.by(sortBy).descending();
            model.addAttribute("teachers", teacherRepository.findAll(sort));
        } else {
            model.addAttribute("teachers", teacherRepository.findAll());
        }

        return "index";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model) {
        generationData(5);
        return "redirect:/api/teacher/list";
    }

    @GetMapping("/clear")
    public String clear(Model model) {
        teacherRepository.deleteAll();
        return "redirect:/api/teacher/list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable Long id) {
        teacherRepository.deleteById(id);
        return "redirect:/api/teacher/list";
    }

    private void generationData(int size) {
        if (teacherRepository.count() == 0) {
            List<Teacher> people = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String name = faker.name().firstName();
                String surname = faker.name().lastName();
                Integer age = faker.number().numberBetween(18,100);
                people.add(new Teacher(name, surname, age));
            }
            teacherRepository.saveAll(people);
        }
    }
}


    //sortirovka
    //on front
    //on  backend (repository , streamApi)


//    @GetMapping("/delete/{id}")
//    public String deleteById(Model model, @PathVariable Long id) {
//        model.addAttribute("title","Home Page");
//        teacherRepository.deleteById(id);
//        model.addAttribute("title","Home Page");
//        model.addAttribute("teachers", teacherRepository.findAll());
//        return  "index";
//    }

    //14:45
    //15:45   (Stop)
    //15:45   (Stop)
    //16:20





//    @GetMapping("/hi")
//    public String hi(Model model) {
////        String str = "Farid Abdullayev";
//        model.addAttribute("title","Home Page");
////        model.addAttribute("sms",str);
////        model.addAttribute("name","Java");
////        model.addAttribute("value",100);
//
////        model.addAttribute("tags",List.of("one","two","three","four","five","six","seven"));
////        model.addAttribute("tags",new String[]{"one","two","three","four","five","six","seven"});
//
////        model.addAttribute("person",new Person("Farid","Abdullayev",29));
////        model.addAttribute("person",new Person("Farid","Abdullayev",29));
//
////        generationData();
//
////        model.addAttribute("people",teacherRepository.findAll());
//
//
////        Map<String,Object> map = new HashMap<>();
////        map.put("name", "Farid");
////        model.addAttribute("people", map);
//
////        model.addAttribute("sms","Hello world!");
//
////        model.addAttribute("person",new Person("Farid","Abdullayev",29));
//
//        return  "index";
//    }


//    private void generationData(int size) {
//
//            if (teacherRepository.count() == 0) {
//                List<Teacher> people = new ArrayList<>();
//                for (int i = 0; i < size; i++) {
//                    String name = faker.name().firstName();
//                    String surname = faker.name().lastName();
//                    Integer age = faker.number().numberBetween(18,100);
//                    people.add(new Teacher(name, surname, age));
//                }
//
//                teacherRepository.saveAll(people);
//            }
//        }

//}
