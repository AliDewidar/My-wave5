package com.pioneers.service.service.student;

import com.pioneers.service.model.dto.StudentDto;
import com.pioneers.service.model.dto.StudentLoginDto;
import com.pioneers.service.model.dto.StudentSignupDto;
import com.pioneers.service.model.entity.Student;

import java.util.List;

public interface StudentService {

    //void save(StudentSignupDto studentDto);

    void save(StudentDto studentDto);

    List<StudentDto> findAll();

    StudentDto findById(String id);

    Student update(String id, StudentSignupDto newStudentDto);

    void removeById(String id);

    StudentDto findFirst();


    void signup(StudentSignupDto studentDto);

    String login(StudentLoginDto studentLoginDto);

    String logout(String userName);
}
