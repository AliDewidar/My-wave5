package com.pioneers.serviceV2.dao.student;

import com.pioneers.serviceV2.model.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Primary
@Component
public class StudentRepositoryImpl implements StudentRepository {

    private final Map<String, Student> students;

    private StudentRepositoryImpl() {
        log.debug("Creating [{}] constructor!! (bean)", this.getClass().getSimpleName());
        students = new HashMap<>();
    }

    @Override
    public Collection<Student> findAll() {
        return students.values();
    }

    @Override
    public Student findById(final String id) {
        return students.get(id);
    }

    @Override
    public void upsert(final Student newStudent) {
        students.put(newStudent.getId(), newStudent);
    }

    @Override
    public void removeById(final String id) {
        students.remove(id);
    }

    @Override
    public Student findFirst() {
        String firstId = students.keySet().stream().findFirst().orElse("");
        return students.get(firstId);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return students.values().stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst();
    }
}
