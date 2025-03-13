package com.pioneers.serviceV3.dao.student;

import com.pioneers.serviceV3.model.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Primary
@Component
public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManager entityManager;

    @Autowired
    public StudentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Collection<Student> findAll() {
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public Optional<Student> findById(final UUID id) {
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

    @Transactional
    @Override
    public void save(final Student newStudent) {
        entityManager.persist(newStudent);
    }

    @Transactional
    @Override
    public void update(final Student newStudent) {
        entityManager.merge(newStudent);
    }

    @Transactional
    @Override
    public void removeById(final UUID id) {
        findById(id).ifPresent(entityManager::remove); // this is the best way to remove an entity
    }


    @Override
    public Optional<Student> findByEmail(String email) {
        return Optional.ofNullable(entityManager.find(Student.class, email));
    }

    @Override
    public Optional<Student> findFirst() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY id ASC", Student.class);
        query.setMaxResults(1);
        return query.getResultList().stream().findFirst();
    }
}
