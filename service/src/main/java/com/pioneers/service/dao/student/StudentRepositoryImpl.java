package com.pioneers.service.dao.student;

import com.pioneers.service.model.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
}
