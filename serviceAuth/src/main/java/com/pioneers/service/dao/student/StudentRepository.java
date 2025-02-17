package com.pioneers.service.dao.student;

import com.pioneers.service.model.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentRepository {

    Collection<Student> findAll();

    Student findById(String id);

    void upsert(Student student);

    void removeById(String id);

    Student findFirst();

    Optional<Student> findByUserName(String userName);
}
