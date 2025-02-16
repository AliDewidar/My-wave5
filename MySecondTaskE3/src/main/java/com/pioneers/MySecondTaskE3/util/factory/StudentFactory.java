package com.pioneers.MySecondTaskE3.util.factory;

import com.pioneers.task.task_edition_two.model.dto.StudentDto;
import com.pioneers.task.task_edition_two.model.entity.Student;

public class StudentFactory {
     public static StudentDto toStudentDto(Student student){
        return new StudentDto(student.getName(), student.getAge(), student.getEmail());
    }

}
