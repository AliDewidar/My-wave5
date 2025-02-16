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

    String signup(SignupDto signupDto);

    String login(LoginDto loginDto);

    String logout(String studentId);

}
