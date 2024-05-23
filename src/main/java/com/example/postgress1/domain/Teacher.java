package com.example.postgress1.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

import static com.example.postgress1.utils.EnsureUtils.ensureThat;
import static org.apache.logging.log4j.util.Strings.isNotBlank;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Teacher {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "employment_type")
    private EmploymentType employmentType;

    @Column(name = "university_department")
    private String universityDepartment;


    public static Teacher forFullTimeTeachers(String name, String secondName, Integer age, String universityDepartment) {
        ensureThat(isNotBlank(universityDepartment), "No mandatory field university department for full time teacher {}, {}", name, secondName);

       return new Teacher(UUID.randomUUID().toString(), name, secondName, age, EmploymentType.FULL_TIME, universityDepartment);
    }

    public enum EmploymentType {
        FULL_TIME, CONTRACTOR
    }
}
