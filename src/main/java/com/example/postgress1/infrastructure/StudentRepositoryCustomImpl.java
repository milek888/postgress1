package com.example.postgress1.infrastructure;

import com.example.postgress1.domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Student> findAllStudentsByEm(String name) {
        Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    // todo criteria
}
