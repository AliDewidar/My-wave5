package com.pioneers.serviceV2.util.factory;

import com.pioneers.serviceV2.model.dto.SignupDto;
import com.pioneers.serviceV2.model.dto.StudentDto;
import com.pioneers.serviceV2.model.entity.Student;
import com.pioneers.serviceV2.util.Utils;
import lombok.NonNull;

import static com.pioneers.serviceV2.util.factory.NamingUtils.*;

public final class StudentFactory {

    private StudentFactory() {
        throw new IllegalStateException("StudentFactory Utility class");
    }

    public static StudentDto toStudentDto(@NonNull Student student) {
        return StudentDto.builder()
                .firstName(extractFirstName(student.getFullName()))
                .secondName(extractSecondName(student.getFullName()))
                .age(student.getAge())
                .email(student.getEmail())
                .gender(student.getGender())
                .password(student.getPassword())
                .phone(student.getPhone())
                .build();
    }


    public static Student toStudent(@NonNull StudentDto studentDto) {

        return Student.builder()
                .id(Utils.createRandomId())
                .fullName(buildFullName(studentDto.getFirstName(), studentDto.getSecondName()))
                .age(studentDto.getAge())
                .email(studentDto.getEmail())
                .gender(studentDto.getGender())
                .password(studentDto.getPassword())
                .phone(studentDto.getPhone())
                .build();
    }

    public static Student toStudent(@NonNull SignupDto signupDto, boolean isloggedIn) {
        return Student.builder()
                .id(Utils.createRandomId())
                .fullName(signupDto.getName())
                .age(signupDto.getAge())
                .email(signupDto.getEmail())
                .gender(signupDto.getGender())
                .password(signupDto.getPassword())
                .build();
    }

    public static Student updateStudent(@NonNull StudentDto newStudentDto, @NonNull Student foundStudent) {
        return Student.builder()
                .id(foundStudent.getId())
                .fullName(buildFullName(newStudentDto.getFirstName(), newStudentDto.getSecondName()))
                .age(newStudentDto.getAge())
                .email(newStudentDto.getEmail())
                .gender(newStudentDto.getGender())
                .password(newStudentDto.getPassword())
                .build();
    }
}
