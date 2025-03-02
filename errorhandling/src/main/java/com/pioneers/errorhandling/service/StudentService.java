package com.pioneers.errorhandling.service;


import com.pioneers.errorhandling.model.dto.LoginDto;
import com.pioneers.errorhandling.model.dto.SignupDto;
import com.pioneers.errorhandling.model.dto.StudentDto;
import com.pioneers.errorhandling.model.entity.Student;

import java.util.List;

public interface StudentService {

    void save(StudentDto studentDto);

    List<StudentDto> findAll();

    StudentDto findById(String id);

    Student update(String id, StudentDto newStudentDto);

    void removeById(String id);

    StudentDto findFirst();

    void signup(SignupDto signupDto);

    void login(LoginDto loginDto);

    void logout(String studentId);

    List<StudentDto> findAllByFirstName(String firstName);
}
