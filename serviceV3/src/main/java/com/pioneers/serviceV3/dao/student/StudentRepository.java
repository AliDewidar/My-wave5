package com.pioneers.serviceV3.dao.student;

import com.pioneers.serviceV3.model.entity.Student;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository {

    Collection<Student> findAll();

    Optional<Student> findById(UUID id);

    void save(Student newStudent);

    void update(Student newStudent);

    void removeById(UUID id);

    Optional<Student> findByEmail(String email);

    Optional<Student> findFirst();
}
