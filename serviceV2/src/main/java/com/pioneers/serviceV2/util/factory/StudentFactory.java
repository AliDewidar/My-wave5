package com.pioneers.serviceV2.util.factory;

import com.pioneers.serviceV2.model.dto.SignupDto;
import com.pioneers.serviceV2.model.dto.StudentDto;
import com.pioneers.serviceV2.model.entity.Student;

import java.util.UUID;

public final class StudentFactory {

    private StudentFactory() {
        throw new IllegalStateException("StudentFactory Utility class");
    }

    public static StudentDto toStudentDto(Student student) {
        //without builder
//        return new StudentDto(student.getName(), student.getAge(), student.getEmail(), student.getGender(), student.getPassword());

        //with builder
        return StudentDto.builder()
                .name(student.getName())
                .age(student.getAge())
                .email(student.getEmail())
                .gender(student.getGender())
                .password(student.getPassword())
                .build();
    }

    public static Student toStudent(StudentDto studentDto) {
        String id = createRandomId();

//        return new Student(id, studentDto.getName(), studentDto.getAge(), studentDto.getEmail(), studentDto.getGender(), studentDto.getPassword());

        return Student.builder()
                .id(id)
                .name(studentDto.getName())
                .age(studentDto.getAge())
                .email(studentDto.getEmail())
                .gender(studentDto.getGender())
                .password(studentDto.getPassword())
                .build();
    }

    public static Student toStudent(SignupDto signupDto,boolean isloggedIn) {
        String id = createRandomId();

//        return new Student(id, signupDto.getName(), signupDto.getAge(), signupDto.getEmail(), signupDto.getGender(), signupDto.getPassword());

        return Student.builder()
                .id(id)
                .name(signupDto.getName())
                .age(signupDto.getAge())
                .email(signupDto.getEmail())
                .gender(signupDto.getGender())
                .password(signupDto.getPassword())
                .build();
    }

    public static Student updateStudent(StudentDto newStudentDto, Student foundStudent) {

        /*return new Student(foundStudent.getId(), newStudentDto.getName(), newStudentDto.getAge(),
                newStudentDto.getEmail(), newStudentDto.getGender(), newStudentDto.getPassword());*/

        return Student.builder()
                .id(foundStudent.getId())
                .name(newStudentDto.getName())
                .age(newStudentDto.getAge())
                .email(newStudentDto.getEmail())
                .gender(newStudentDto.getGender())
                .password(newStudentDto.getPassword())
                .build();
    }

    public static String createRandomId() {
        return UUID.randomUUID().toString();
    }
}
