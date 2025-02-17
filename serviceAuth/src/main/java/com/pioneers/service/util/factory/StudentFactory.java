package com.pioneers.service.util.factory;

import com.pioneers.service.model.dto.StudentDto;
import com.pioneers.service.model.dto.StudentSignupDto;
import com.pioneers.service.model.entity.Student;

import java.util.UUID;

public final class StudentFactory {

    private StudentFactory() {
        throw new IllegalStateException("StudentFactory Utility class");
    }

    public static StudentDto toStudentDto(Student student) {
        return new StudentDto();
    }

    public static Student toStudent(StudentDto studentDto) {
        String id = createRandomId();
        return new Student();
    }

    public static Student toStudent(StudentSignupDto studentSignupDto,boolean isLogin) {
        String id = createRandomId();
        return new Student(id,studentSignupDto.getUsername(), studentSignupDto.getPassword(), studentSignupDto.getAge(),
                studentSignupDto.getEmail(), studentSignupDto.getGender(),isLogin);
    }

    public static Student updateStudent(StudentSignupDto newStudentDto, Student foundStudent) {
        return new Student();
    }

    private static String createRandomId() {
        return UUID.randomUUID().toString();
    }
}
