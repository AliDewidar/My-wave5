package com.pioneers.MySecondTaskE4_task5.dao.Student;

import com.pioneers.MySecondTaskE4_task5.model.entity.Student;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentRepositoryImpl implements StudentRepository {

    private final Map<String, Student> students = new HashMap<>();

    @Override
    public Collection<Student> findAll() {
        return students.values();
    }

    @Override
    public Student findById(String id) {
        return students.get(id);
    }

    @Override
    public void upsert(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public void removeById(String id) {
        students.remove(id);
    }

    @Override
    public Student findFirst() {
        return students.values().stream().findFirst().orElse(null);
    }
}