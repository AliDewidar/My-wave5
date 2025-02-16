package com.pioneers.MySecondTaskE4_task5.dao.Student;

import com.pioneers.MySecondTaskE4_task5.model.entity.Student;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentRepositoryImpl implements StudentRepository {

    private final Map<String, Student> students;

    private StudentRepositoryImpl() {
        System.out.println("Creating [ " + this.getClass().getSimpleName() + " ] empty constructor (Bean)");
        students = new HashMap<>();
    }

    public Collection<Student> findAll() {
        return students.values();
    }

    public Student findById(String id) {
        return students.get(id);
    }

    public void upsert(Student newStudent) {
        students.put(newStudent.getId(), newStudent);
    }

    public void removeById(String id) {
        students.remove(id);
    }

    public Student findFirst() {
        String firstId = students.keySet().stream().findFirst().orElse("");
        return students.get(firstId);
    }
}
