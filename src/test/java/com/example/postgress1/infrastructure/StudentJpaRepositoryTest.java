package com.example.postgress1.infrastructure;

import com.example.postgress1.PostgreSqlRepositorylTest;
import com.example.postgress1.application.DepartmentRepository;
import com.example.postgress1.application.StudentRepository;
import com.example.postgress1.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class StudentJpaRepositoryTest extends PostgreSqlRepositorylTest { // todo zastanowic sie jakie testy tu w ogole maja sens bo na razie to jest testowanie hibernat-a i JPA

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Test
    void shouldFindAllStudentsByDepartment() {
        // given
        var department = departmentRepository.findById("1").orElse(null);
        var student = Student.builder() // todo data mother
                .id("2")
                .name("Robert")
                .secondName("Luberda")
                .age(45)
                .department(department)
                .build();
        department.getStudents().add(student); // todo poczytac o tym i poexperymentowac co sie w bazie zapisze jak tego nie dodamy (zobaczyc jak w Kitopi zrobione)

        //when
        studentRepository.save(student);

        //then
        var studentFromDb = studentRepository.findById(("2")).orElse(null);
        System.out.println("------------------"); // todo figure out assertions check in kitopi repos how they do that
    }


    @Test
    void shouldFindAllStudentsByEm() {
        // given
        var department = departmentRepository.findById("1").orElse(null);
        var student = Student.builder() // todo data mother
                .id("2")
                .name("Robert")
                .secondName("Luberda")
                .age(45)
                .department(department)
                .build();
        department.getStudents().add(student); // todo poczytac o tym i poexperymentowac co sie w bazie zapisze jak tego nie dodamy (zobaczyc jak w Kitopi zrobione)

        //when
        studentRepository.save(student);

        var studentFromDb = studentRepository.findAllStudentsByEm("Robert");
        System.out.println("------------------"); // todo figure out assertions check in kitopi repos how they do that
    }

}