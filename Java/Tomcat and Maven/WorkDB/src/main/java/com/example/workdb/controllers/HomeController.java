package com.example.workdb.controllers;

import com.example.workdb.DTOs.TeacherDTO;
import com.example.workdb.entities.Teacher;
import com.example.workdb.repositories.TeacherRepository;
//import com.example.workdb.services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class HomeController {

//    @Autowired
//    private TeacherServices teacherServices;

    @Autowired
    private TeacherRepository teacherRepository;

//    @GetMapping("/")
//    public Page<Teacher> getALL(
//            @RequestParam Integer count,
//            @RequestParam Integer size,
//            @RequestParam String sort,
//            @RequestParam String type
//    ) {
//
//        //1000
//
//        //pages = 10
//
//        //3 , 100
//
//        Pageable pageable = null;
//
//        if (type.equalsIgnoreCase("desc")) {
//             pageable = PageRequest.of(count, size, Sort.by(sort).descending());
//        }else{
//             pageable = PageRequest.of(count, size, Sort.by(sort).ascending());
//        }
//        return  teacherRepository.findAll(pageable);
//

    /// /        return (List<Teacher>) teacherRepository.findAll(Sort.by(type).descending().and(Sort.by(type).ascending()));
//        //SELECT * FROM Teachers ORDER BY Age asc
//    }
//    @GetMapping("/")
//    public List<Teacher> getALL(
//            @RequestParam Integer age
//    ) {
//        return teacherRepository.findByAgeGreaterThan(age);
//    }

//    @GetMapping("/")
//    public List<TeacherDTO> getALL(
//    ) {
//        return teacherRepository.skubidu().stream().map(t->new TeacherDTO(t)).toList();
//    }

//    @GetMapping("/")
//    public List<TeacherDTO> getALL(
//    ) {
//        return teacherRepository.skubidu();
//    }

    @GetMapping("/")
    public List<Teacher> getALL(
    ) {
//        return teacherRepository.skubidu("mo");
        return teacherRepository.skubidu( );
    }


    @GetMapping("/farid")
    public List<String> getAllFarid(
    ) {
//        return teacherRepository.skubidu("mo");
        return List.of("Hello World");
    }


//    @GetMapping("/")
//    public ResponseEntity<List<Teacher>> getALL(){
////        return ResponseEntity.ok(teacherServices.findAll());
//    }



}
