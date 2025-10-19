//package com.example.workdb.controllers;
//
//import com.example.workdb.entities.Teacher;
//import com.example.workdb.models.Person;
//import com.example.workdb.repositories.TeacherRepository;
////import com.example.workdb.services.TeacherServices;
//import com.github.javafaker.Faker;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////MVC (M-odal , V-iew , C-ontroller)
////Model        - soderjit klassi
////View         - za vizualizaciyu
////Controller   - obrabativaet zaprosi i obnovlyayet view
//
//
//@Controller
//@RequestMapping("/api/teacher")
//public class HomeController {
//
//    @Autowired
//    private TeacherRepository teacherRepository;
//
//    @Autowired
//    private Faker faker;
//
//
//    @GetMapping("/list")
//    public String hi(Model model) {
//        model.addAttribute("title","Home Page");
//        model.addAttribute("teachers", teacherRepository.findAll());
//        return  "index";
//    }
//    @GetMapping("/addAuthor")
//    public String addAuthor(Model model) {
//        generationData(10);
//        return  "redirect:/api/teacher/list";
//    }
//    @GetMapping("/clear")
//    public String clear(Model model) {
//        teacherRepository.deleteAll();
//        return  "redirect:/api/teacher/list";
//    }
//    @DeleteMapping("/delete/{id}")
//    public String deleteById(Model model, @PathVariable Long id) {
//        teacherRepository.deleteById(id);
//        return  "redirect:/api/teacher/list";
//    }
//
//    @ResponseBody
//    @DeleteMapping("/api/delete/{id}")
//    public String deleteByIdAjax( @PathVariable Long id) {
//      Teacher teacher =  teacherRepository.getById(id);
//      teacherRepository.delete(teacher);
//      return  "Teacher deleted => " + teacher;
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editById(Model model, @PathVariable Long id) {
//        Teacher teacher = teacherRepository.findById(id).orElse(null);
//        System.out.println(teacher);
//        model.addAttribute("teacher",teacher);
//        return  "update";
//    }
//    @PostMapping("/update")
//    public String updateById(Model model, Teacher teacher) {
//        System.out.println(teacher);
//        teacherRepository.save(teacher);
//        return  "redirect:/api/teacher/list";
//    }
//
//    @GetMapping("/add")
//    public String add(Model model) {
//        model.addAttribute("title","Add Teacher");
//        model.addAttribute("teacher",new Teacher());
//        return  "create";
//    }
//
//
//    @PostMapping("/add")
//    public String add(Model model, @Valid Teacher teacher, BindingResult result) {
//
//
//       if (result.hasErrors()) {
//           model.addAttribute("error","Proverti vse polya");
//           model.addAttribute("teacher",teacher);
//           return "create";
//       }else{
//           teacherRepository.save(teacher);
//           return  "redirect:/api/teacher/list";
//       }
//
//    }
//
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
//
//}
