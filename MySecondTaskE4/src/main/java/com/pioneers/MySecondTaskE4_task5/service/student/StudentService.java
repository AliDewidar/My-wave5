package com.pioneers.MySecondTaskE4_task5.service.student;


import com.pioneers.MySecondTaskE4_task5.model.dto.StudentDto;
import com.pioneers.MySecondTaskE4_task5.model.entity.Student;

import java.util.List;

public interface StudentService {

    void save(StudentDto studentDto);

    List<StudentDto> findAll();

    StudentDto findById(String id);

    Student update(String id, StudentDto newStudentDto);

    void removeById(String id);

    StudentDto findFirst();
}
