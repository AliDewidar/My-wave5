package com.pioneers.MySecondTaskE3.dao.Student;

import com.pioneers.task.task_edition_two.model.dto.StudentDto;

import java.util.List;

public interface StudentRepository {

    void save(StudentDto studentDto);

    List<StudentDto> findAll();

    StudentDto findById(String id);

    void update(String id, StudentDto studentDto);

    void removeById(String id);

    StudentDto findFirst();
}
