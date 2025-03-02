package com.pioneers.MySecondTaskE3.util.factory;


import com.pioneers.MySecondTaskE3.model.dto.StudentDto;
import com.pioneers.MySecondTaskE3.model.entity.Student;

public class StudentFactory {
     public static StudentDto toStudentDto(Student student){
        return new StudentDto(student.getName(), student.getAge(), student.getEmail());
    }

}
