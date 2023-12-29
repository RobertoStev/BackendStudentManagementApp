package com.project.studentmanager.controller;

import com.project.studentmanager.entity.Student;
import com.project.studentmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("add")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(service.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return service.findAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.findStudentById(id), HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return new ResponseEntity<>(service.updateStudent(student), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id){
        service.deleteStudent(id);
        return new ResponseEntity<>("Student with id " + id + " was deleted successfully!", HttpStatus.OK);
    }
}
