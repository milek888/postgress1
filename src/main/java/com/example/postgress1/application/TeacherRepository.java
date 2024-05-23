package com.example.postgress1.application;

import com.example.postgress1.domain.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository {

    Optional<Teacher> findById(String id);

    List<Teacher> findAll();

    List<Teacher> findTeacherBySecondName(String secondName);

    Teacher save(Teacher teacher);

}
