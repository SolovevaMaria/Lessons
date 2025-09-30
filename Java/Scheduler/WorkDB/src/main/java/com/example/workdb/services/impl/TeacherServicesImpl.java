package com.example.workdb.services.impl;

import com.example.workdb.entities.Teacher;
import com.example.workdb.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public class TeacherServicesImpl implements TeacherServices {

//    @Autowired
//    private TeacherRepository teacherRepository;
//
//    @Override
//    public List<Teacher> findAll() {
////        Iterable<Teacher> all = teacherRepository.findAll();
//
//        Iterable<Teacher> all = teacherRepository.;
//        return (List<Teacher>) all;
////        List<TeacherDTO> all = teacherRepository.findAll().stream().map(
////                x->{
////                    TeacherDTO tDTO = new TeacherDTO(x);
////
////                    return tDTO;
////                }
////        ).toList();
////        return all ;
//    }

//    public Teacher save(Teacher teacher) {
//        return teacherRepository.save(teacher);
////        List<TeacherDTO> all = teacherRepository.findAll().stream().map(
////                x->{
////                    TeacherDTO tDTO = new TeacherDTO(x);
////
////                    return tDTO;
////                }
////        ).toList();
////        return all ;
//    }
//}
