package com.example.postgress1.application;

import com.example.postgress1.domain.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Optional<Student> findById(String id);

    List<Student> findAll();

    List<Student> findAllStudentsByDepartment(@Param("name") String name);

    List<Student> findAllStudentsByEm(String name);

    Student save(Student student);

}
