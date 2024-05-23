package com.example.postgress1.infrastructure;

import com.example.postgress1.domain.Teacher;

public class TeacherDataMother {


    public static Teacher.TeacherBuilder aTeacher() {
        return Teacher.builder()
                .id("1")
                .name("Krzysztof")
                .secondName("Ciesielski")
                .age(50)
                .build()
                .toBuilder();
    }
}
