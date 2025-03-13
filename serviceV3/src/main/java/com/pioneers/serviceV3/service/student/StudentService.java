package com.pioneers.serviceV3.service.student;

import com.pioneers.serviceV3.model.dto.StudentDto;
import com.pioneers.serviceV3.model.entity.Student;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    void save(StudentDto studentDto);

    List<StudentDto> findAll();

    StudentDto findById(UUID id);

    Student update(UUID id, StudentDto newStudentDto);

    void removeById(UUID id);

    StudentDto findFirst();
}
