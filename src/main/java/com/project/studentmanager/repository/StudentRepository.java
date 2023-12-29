package com.project.studentmanager.repository;

import com.project.studentmanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    Optional<Student> findStudentByStudentIndex(String index);
}
