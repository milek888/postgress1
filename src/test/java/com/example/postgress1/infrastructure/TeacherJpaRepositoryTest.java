package com.example.postgress1.infrastructure;

import com.example.postgress1.PostgreSqlRepositorylTest;
import com.example.postgress1.application.TeacherRepository;
import com.example.postgress1.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static com.example.postgress1.infrastructure.TeacherDataMother.aTeacher;

/*
* Tutaj jest to swietnie opisane
* https://josefczech.cz/2020/02/02/datajpatest-testentitymanager-flush-clear/
* */
@TestPropertySource(properties = {
        "logging.level.ROOT= WARN",
        "logging.level.org.springframework.test.context.transaction= INFO",
        "logging.level.org.hibernate.SQL= DEBUG"
})
class TeacherJpaRepositoryTest extends PostgreSqlRepositorylTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TestEntityManager testEntityManager;


    @Test
    void shouldFindTeacherById() {
        //given
        var teacher = aTeacher().build();

        //when
        teacherRepository.save(teacher);
        testEntityManager.flush(); // todo bardzo wazne to zapisuje w bazie
        testEntityManager.clear(); // to czysci persistance context dzieki temu mamy gwarancje ze to co w asercji porownamy to bedzie obiekt wyciagniety z bazy a nie z persistance contextu

        //then
        var teacherFromDb = teacherRepository.findById("1").orElse(null);

        System.out.println("==="); // todo figure out assertions
    }

    @Test
    void shouldFindTeacherBySecondName() {
        //given
        restoreDatabase();
        var teacher = aTeacher().build();

        //when
        teacherRepository.save(teacher);
        testEntityManager.flush(); // todo bardzo wazne to zapisuje w bazie
        testEntityManager.clear(); // to czysci persistance context dzieki temu mamy gwarancje ze to co w asercji porownamy to bedzie obiekt wyciagniety z bazy a nie z persistance contextu

        //then
        List<Teacher> teachers = teacherRepository.findTeacherBySecondName("Ciesielski");

        System.out.println("==="); // todo figure out assertions
    }

}