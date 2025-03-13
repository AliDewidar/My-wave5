package com.pioneers.serviceV2.service.student;

import com.pioneers.serviceV2.model.dto.LoginDto;
import com.pioneers.serviceV2.model.dto.SignupDto;
import com.pioneers.serviceV2.model.dto.StudentDto;
import com.pioneers.serviceV2.model.entity.Student;

import java.util.List;

public interface StudentService {

    void save(StudentDto studentDto);

    List<StudentDto> findAll();

    StudentDto findById(String id);

    Student update(String id, StudentDto newStudentDto);

    void removeById(String id);

    void deleteAll();

    StudentDto findFirst();

    List<StudentDto> findAllByFirstName(String firstName);
}
