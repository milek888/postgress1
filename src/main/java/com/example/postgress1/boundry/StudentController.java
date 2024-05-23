package com.example.postgress1.boundry;

import com.example.postgress1.application.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static com.example.postgress1.boundry.StudentFactory.toStudentDocument;

@Slf4j
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/{id}")
    StudentDocument getStudent(@PathVariable String id) {
        var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return toStudentDocument(student);
    }

    @GetMapping
    List<StudentDocument> getStudents() {
        return studentRepository.findAll().stream()
                .map(StudentFactory::toStudentDocument)
                .toList();
    }

    @GetMapping("/byEm")
    List<StudentDocument> getStudents(@RequestParam("name") String name) {
        return studentRepository.findAllStudentsByEm(name).stream()
                .map(StudentFactory::toStudentDocument)
                .toList();
    }

    @GetMapping("/department")
    List<StudentDocument> getStudentsByDepartmentName(@RequestParam("name") String name) {
        return studentRepository.findAllStudentsByDepartment(name).stream()
                .map(StudentFactory::toStudentDocument)
                .toList();
    }

    @PostMapping
    void saveStudent(@RequestBody StudentDocument studentDocument) {
        studentRepository.save(StudentFactory.toStudent(studentDocument));
    }

}
