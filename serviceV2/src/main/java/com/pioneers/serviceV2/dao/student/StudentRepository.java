package com.pioneers.serviceV2.dao.student;

import com.pioneers.serviceV2.model.entity.Student;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Collection<Student> findAll();

    Optional<Student> findById(String id);

    void upsert(Student student);

    void removeById(String id);

    Student findFirst();

    Optional<Student> findByEmail(String email);

    List<Student> findAllByFirstName(String firstName);
}
