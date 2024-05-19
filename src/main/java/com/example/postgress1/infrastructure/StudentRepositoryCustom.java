package com.example.postgress1.infrastructure;

import com.example.postgress1.domain.Student;

import java.util.List;

public interface StudentRepositoryCustom {

    List<Student> findAllStudentsByEm(String name);

}
