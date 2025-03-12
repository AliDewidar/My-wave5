package com.pioneers.serviceV2.dao.student;

import com.pioneers.serviceV2.database.StudentsDb;
import com.pioneers.serviceV2.model.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.pioneers.serviceV2.util.factory.NamingUtils.extractFirstName;
import static com.pioneers.serviceV2.util.factory.NamingUtils.isNameMatched;

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
    public Optional<Student> findById(final String id) {
        return Optional.ofNullable(studentsDb.getStudents().get(id));
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

    @Override
    public List<Student> findAllByFirstName(String firstName) {
        return studentsDb.getStudents().values().stream()
                .filter(student -> isNameMatched(extractFirstName(student.getFullName()),firstName))
                .toList();
    }
}
