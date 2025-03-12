package com.pioneers.service.dao.student;

import com.pioneers.service.database.StudentsDb;
import com.pioneers.service.model.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Primary
@Component
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentsDb studentsDb;

    @Autowired
    public StudentRepositoryImpl(StudentsDb studentsDb) {
        this.studentsDb = studentsDb;
    }

    @Override
    public Collection<Student> findAll() {
        return studentsDb.getStudents().values();
    }

    @Override
    public Student findById(final String id) {
        return studentsDb.getStudents().get(id);
    }

    @Override
    public void upsert(final Student newStudent) {
        studentsDb.getStudents().put(newStudent.getId(), newStudent);
    }

    @Override
    public void removeById(final String id) {
        studentsDb.getStudents().remove(id);
    }

    @Override
    public Student findFirst() {
        String firstId = studentsDb.getStudents().keySet().stream().findFirst().orElse("");
        return studentsDb.getStudents().get(firstId);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return studentsDb.getStudents().values().stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst();
    }
}
