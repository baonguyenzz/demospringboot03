package com.cybersoft.demospringboot03.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybersoft.demospringboot03.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<Student> listStudent = new ArrayList<>();

    @GetMapping("")
    public ResponseEntity<?> getAllStudent() {
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudentBody(@RequestBody Student student) {
        listStudent.add(student);
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @PostMapping("/add1")
    public ResponseEntity<?> addStudent(@RequestParam String name, @RequestParam int age) {
        Student student = new Student(name, age);
        listStudent.add(student);
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @PostMapping("/add/{name}/{age}")
    public ResponseEntity<?> addStudentPath(@PathVariable String name, @PathVariable int age) {
        Student student = new Student(name, age);
        listStudent.add(student);
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

}
