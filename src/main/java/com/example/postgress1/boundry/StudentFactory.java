package com.example.postgress1.boundry;

import com.example.postgress1.domain.Student;

class StudentFactory {

    static StudentDocument toStudentDocument(Student student) {
        return StudentDocument.builder()
                .id(student.getId())
                .name(student.getName())
                .secondName(student.getSecondName())
                .age(student.getAge())
                .build();
    }

    static Student toStudent(StudentDocument studentDocument) {
        return Student.builder()
                .id(studentDocument.id())
                .name(studentDocument.name())
                .secondName(studentDocument.secondName())
                .age(studentDocument.age())
                .build();
    }

}
