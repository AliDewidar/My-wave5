package com.pioneers.errorhandling.dao;

import com.pioneers.errorhandling.model.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.pioneers.errorhandling.util.factory.NamingUtils.extractFirstName;
import static com.pioneers.errorhandling.util.factory.NamingUtils.isNameMatched;

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

    @Override
    public List<Student> findAllByFirstName(String firstName) {
        return students.values().stream()
//                .filter(student -> extractFirstName(student.getFullName()).equalsIgnoreCase(firstName))
                .filter(student -> isNameMatched(extractFirstName(student.getFullName()),firstName))
                .toList();
    }


}
