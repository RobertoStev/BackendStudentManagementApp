package com.project.studentmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String studentIndex;
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_Id"),
            inverseJoinColumns = @JoinColumn(name = "course_Id"))
    private List<Course> courses;
}
