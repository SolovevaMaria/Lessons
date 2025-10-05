package com.example.workdb.controllers;

import com.example.workdb.entities.Teacher;
import com.example.workdb.models.Person;
import com.example.workdb.repositories.TeacherRepository;
import com.github.javafaker.Faker;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
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

    @GetMapping("/list")
    public String hi(
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "1") int page,
            Model model) {

      List<Teacher> teachers = teacherRepository.findAll();

        if (!teachers.isEmpty()) {
            model.addAttribute("title","Home Page");

            int totalTeachers =(int)teacherRepository.count();;
            int totalPages = (int) Math.ceil((double) totalTeachers/size);
            int fromIndex = (page-1) * size;
            int toIndex = fromIndex + size;


            int sizePage = 10;
            int startPage = Math.max(1,page - sizePage / 2);
            int endPage = Math.min(startPage + sizePage, totalPages);

            List<Teacher> people = teachers.subList(fromIndex, toIndex);

            model.addAttribute("title","Home Page");
            model.addAttribute("teachers",people );
            model.addAttribute("size",size );
            model.addAttribute("currentPage",page );
           model.addAttribute("startPage",startPage );
            model.addAttribute("endPage",endPage );
            model.addAttribute("totalTeachers",totalTeachers );
            model.addAttribute("totalPages",totalPages );

        }else{
            model.addAttribute("teachers",new ArrayList<Teacher>() );
        }

        return  "index";
    }

    @GetMapping("/addAuthor")
    public String addAuthor(Model model) {
        generationData(103);
        return  "redirect:/api/teacher/list";
    }
    @GetMapping("/clear")
    public String clear(Model model) {
        teacherRepository.deleteAll();
        return  "redirect:/api/teacher/list";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(Model model, @PathVariable Long id) {
        teacherRepository.deleteById(id);
        return  "redirect:/api/teacher/list";
    }

    @ResponseBody
    @DeleteMapping("/api/delete/{id}")
    public String deleteByIdAjax( @PathVariable Long id) {
        Teacher teacher =  teacherRepository.getById(id);
        teacherRepository.delete(teacher);
        return  "Teacher deleted => " + teacher;
    }

    @ResponseBody
    @GetMapping("/api/filter/{search}")
    public List<Teacher> filterTeachers(@PathVariable String search) {
        return teacherRepository.findAllByStr(search);
    }



    @GetMapping("/edit/{id}")
    public String editById(Model model, @PathVariable Long id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        System.out.println(teacher);
        model.addAttribute("teacher",teacher);
        return  "update";
    }
    @PostMapping("/update")
    public String updateById(Model model, Teacher teacher) {
        System.out.println(teacher);
        teacherRepository.save(teacher);
        return  "redirect:/api/teacher/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("title","Add Teacher");
        model.addAttribute("teacher",new Teacher());
        return  "create";
    }


    @PostMapping("/add")
    public String add(Model model, @Valid Teacher teacher, BindingResult result) {

       if (result.hasErrors()) {
           model.addAttribute("error","Proverti vse polya");
           model.addAttribute("teacher",teacher);
           return "create";
       }else{
           teacherRepository.save(teacher);
           return  "redirect:/api/teacher/list";
       }

    }

    @GetMapping("/api/sort")
    @ResponseBody
    public List<Teacher> sortTeachers(
            @RequestParam String column,
            @RequestParam String direction
    ) {
        return teacherRepository.findAll();
    }

    private void generationData(int size) {

            if (teacherRepository.count() == 0) {
                List<Teacher> people = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    String name = faker.name().firstName();
                    String surname = faker.name().lastName();
                    String email = faker.internet().emailAddress();
                    Integer age = faker.number().numberBetween(18,100);
                    people.add(new Teacher(name, surname,email, age));
                }

                teacherRepository.saveAll(people);
            }
        }

}
