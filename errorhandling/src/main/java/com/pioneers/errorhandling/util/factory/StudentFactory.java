package com.pioneers.errorhandling.util.factory;

import com.pioneers.errorhandling.model.dto.SignupDto;
import com.pioneers.errorhandling.model.dto.StudentDto;
import com.pioneers.errorhandling.model.entity.Student;

import static com.pioneers.errorhandling.util.Utils.createRandomId;
import static com.pioneers.errorhandling.util.factory.NamingUtils.*;

public final class StudentFactory {

    private StudentFactory() {
        throw new IllegalStateException("StudentFactory Utility class");
    }

    public static StudentDto toStudentDto(Student student) {
        //without builder
//        return new StudentDto(student.getName(), student.getAge(), student.getEmail(), student.getGender(), student.getPassword());

        //with builder
        return StudentDto.builder()
                .firstName(extractFirstName(student.getFullName()))
                .secondName(extractSecondName(student.getFullName()))
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
                .fullName(buildFullName(studentDto.getFirstName(), studentDto.getSecondName()))
                .age(studentDto.getAge())
                .email(studentDto.getEmail())
                .gender(studentDto.getGender())
                .password(studentDto.getPassword())
                .build();
    }

    public static Student toStudent(SignupDto signupDto, boolean isloggedIn) {
//        String id = createRandomId();

//        return new Student(id, signupDto.getName(), signupDto.getAge(), signupDto.getEmail(), signupDto.getGender(), signupDto.getPassword());

        return Student.builder()
                .id(createRandomId())
                .fullName(signupDto.getName())
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
                .fullName(buildFullName(newStudentDto.getFirstName(), newStudentDto.getSecondName()))
                .age(newStudentDto.getAge())
                .email(newStudentDto.getEmail())
                .gender(newStudentDto.getGender())
                .password(newStudentDto.getPassword())
                .build();
    }
}
