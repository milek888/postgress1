package com.example.postgress1.infrastructure;

import com.example.postgress1.application.TeacherRepository;
import com.example.postgress1.domain.Student;
import com.example.postgress1.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeacherJpaRepository extends TeacherRepository, JpaRepository<Teacher, Integer> {


    @Override
    @Query("SELECT t FROM Teacher t WHERE t.secondName = :secondName")
    List<Teacher> findTeacherBySecondName(@Param("secondName") String secondName);

}