package com.pioneers.service.util.factory;

import com.pioneers.service.model.dto.SignupDto;
import com.pioneers.service.model.dto.StudentDto;
import com.pioneers.service.model.entity.Student;

import java.util.UUID;

public final class StudentFactory {

    private StudentFactory() {
        throw new IllegalStateException("StudentFactory Utility class");
    }

    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(student.getName(), student.getAge(), student.getEmail(), student.getGender(), student.getPassword());
    }

    public static Student toStudent(StudentDto studentDto) {
        String id = createRandomId();
        return new Student(id, studentDto.getName(), studentDto.getAge(), studentDto.getEmail(), studentDto.getGender(), studentDto.getPassword());
    }

    public static Student toStudent(SignupDto signupDto,boolean isloggedIn) {
        String id = createRandomId();
        return new Student(id,signupDto.getName(), signupDto.getAge(), signupDto.getEmail(), signupDto.getGender(), signupDto.getPassword());
    }

    public static Student updateStudent(StudentDto newStudentDto, Student foundStudent) {
        return new Student(foundStudent.getId(), newStudentDto.getName(), newStudentDto.getAge(),
                newStudentDto.getEmail(), newStudentDto.getGender(), newStudentDto.getPassword());
    }

    public static String createRandomId() {
        return UUID.randomUUID().toString();
    }
}
