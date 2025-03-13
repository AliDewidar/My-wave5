package com.pioneers.serviceV3.util.factory;

import com.pioneers.serviceV3.model.dto.SignupDto;
import com.pioneers.serviceV3.model.dto.StudentDto;
import com.pioneers.serviceV3.model.entity.Student;
import com.pioneers.serviceV3.util.Utils;
import lombok.NonNull;

import static com.pioneers.serviceV3.util.factory.NamingUtils.*;

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
                .build();
    }


    public static Student toStudent(@NonNull StudentDto studentDto) {

        return Student.builder()
                .id(Utils.createRandomId())
                .fullName(buildFullName(studentDto.getFirstName(), studentDto.getSecondName()))
                .age(studentDto.getAge())
                .email(studentDto.getEmail())
                .gender(studentDto.getGender())
                .build();
    }

    public static Student updateStudent(@NonNull StudentDto newStudentDto, @NonNull Student foundStudent) {
        return Student.builder()
                .id(foundStudent.getId())
                .fullName(buildFullName(newStudentDto.getFirstName(), newStudentDto.getSecondName()))
                .age(newStudentDto.getAge())
                .email(newStudentDto.getEmail())
                .gender(newStudentDto.getGender())
                .build();
    }
}
