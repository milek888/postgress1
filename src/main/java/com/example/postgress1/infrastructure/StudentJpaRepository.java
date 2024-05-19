package com.example.postgress1.infrastructure;

import com.example.postgress1.application.StudentRepository;
import com.example.postgress1.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentJpaRepository extends StudentRepository, StudentRepositoryCustom ,JpaRepository<Student, Integer> {


    @Override
    @Query("SELECT s FROM Student s, Department d WHERE s.department.id = d.id AND d.name = :name")
    List<Student> findAllStudentsByDepartment(@Param("name") String name);

}
