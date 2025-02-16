package com.pioneers.MySecondTaskE4_task5.service.student;

import com.pioneers.MySecondTaskE4_task5.model.dto.*;
import com.pioneers.MySecondTaskE4_task5.model.entity.Student;

import java.util.List;

public interface StudentService {
    String save(StudentDto studentDto);
    String signup(SignupDto signupDto);
    String login(LoginDto loginDto);
    String logout(String studentId);
    List<StudentDto> findAll(String studentId);
    StudentDto findById(String id, String studentId);
    Student update(String id, StudentDto updateDto, String studentId);
    void removeById(String id, String studentId);
    StudentDto findFirst(String studentId);
}