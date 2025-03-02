package com.pioneers.service.service.student;

import com.pioneers.service.model.dto.LoginDto;
import com.pioneers.service.model.dto.SignupDto;
import com.pioneers.service.model.dto.StudentDto;
import com.pioneers.service.model.entity.Student;

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

}
