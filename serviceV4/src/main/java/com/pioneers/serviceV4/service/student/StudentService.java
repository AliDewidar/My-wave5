package com.pioneers.serviceV4.service.student;

import com.pioneers.serviceV4.model.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    void save(StudentDto studentDto);

    List<StudentDto> findAll();

    StudentDto findById(UUID id);

    StudentDto update(UUID id, StudentDto newStudentDto);

    void removeById(UUID id);

    StudentDto findFirst();

    StudentDto findByEmail(String email);

    void deleteAll();
}
