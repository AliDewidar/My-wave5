package com.pioneers.MySecondTaskE4_task5.util.factory;


import com.pioneers.MySecondTaskE4_task5.model.dto.StudentDto;
import com.pioneers.MySecondTaskE4_task5.model.entity.Student;

import java.util.UUID;

public class StudentFactory {

     public static StudentDto toStudentDto(Student student){
        return new StudentDto(student.getName(), student.getAge(), student.getEmail() , student.getGender(), student.getPassword());
    }

    public static Student toStudent(StudentDto studentDto) {
        String id = createRandomId();
        return new Student(id, studentDto.getName(), studentDto.getAge(),
                studentDto.getEmail(), studentDto.getGender(),studentDto.getPassword());
    }

    //الميثود دي وحشه عشان بتعتمد على mutation reference بتاخد اوبجكت وتعمله set
    /*public static void updateStudent(StudentDto newStudentDto, Student foundStudent) {
        foundStudent.setName(newStudentDto.getName());
        foundStudent.setAge(newStudentDto.getAge());
        foundStudent.setGender(newStudentDto.getGender());
    }*/

    //دي افضل منها شوية
    public static Student updateStudent(StudentDto newStudentDto, Student foundStudent) {
        return new Student(foundStudent.getId(), newStudentDto.getName(), newStudentDto.getAge(),
                newStudentDto.getEmail(), newStudentDto.getGender(),newStudentDto.getPassword());
    }

    public static String createRandomId() {
        return UUID.randomUUID().toString();
    }

}
