package com.project.studentmanager.service;

import com.project.studentmanager.entity.Student;
import com.project.studentmanager.exception.ResourceNotFoundException;
import com.project.studentmanager.repository.StudentRepository;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student){
        return repository.save(student);
    }
    public List<Student> findAllStudents(){
        return repository.findAll();
    }
    public Student findStudentById(Long id){
        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));
    }

    public Student findStudentByEmail(String email){
        return repository.findStudentByEmail(email).orElse(null);
    }

    public Student findStudentByIndex(String index){
        return repository.findStudentByStudentIndex(index).orElse(null);
    }
    public Student updateStudent(Student student){
        Student existingStudent = repository.findById(student.getStudentId()).orElseThrow(() ->
                new ResourceNotFoundException(student.getStudentId()));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setStudentId(student.getStudentId());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);
    }

    public void deleteStudent(Long id){
        Student existingStudent = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id));

        repository.deleteById(id);
    }

}
