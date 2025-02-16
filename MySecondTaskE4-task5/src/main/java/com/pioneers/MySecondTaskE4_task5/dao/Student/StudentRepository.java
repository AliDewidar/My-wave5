package com.pioneers.MySecondTaskE4_task5.dao.Student;

import com.pioneers.MySecondTaskE4_task5.model.entity.Student;
import java.util.Collection;

public interface StudentRepository {
    Collection<Student> findAll();
    Student findById(String id);
    void upsert(Student student);
    void removeById(String id);
    Student findFirst();
}