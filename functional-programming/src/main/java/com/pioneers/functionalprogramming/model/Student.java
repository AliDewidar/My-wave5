package com.pioneers.functionalprogramming.model;

import lombok.Builder;
import lombok.Data;

import java.util.function.Function;

import static com.pioneers.functionalprogramming.util.FirstClassCitizen.findStudentInfo;

@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    public static String retrieveStudentName(Student student) {
        return student.getFirstName() + " " + student.getLastName();
    }

    public static String retrieveStudentEmail(Student student) {
        return student.getEmail();
    }

    public static String convertAgeToString(Student student) {
        return String.valueOf(student.getAge());
    }

    public static String doProcesses(Function<Student, String> doFirstProcess, Function<String, String> doSecondProcess, Student student) {
        return doFirstProcess.andThen(doSecondProcess).apply(student);
    }

    public static void main(String[] args) {

        Student student = Student.builder()
                .firstName("Ali")
                .lastName("Mohamed")
                .age(23)
                .email("ali.mohamed@techpioneershub.com")
                .build();
 
        String result1 = Student.doProcesses(
                Student::retrieveStudentName,
                name -> name + " - " + student.getEmail(),
                student
        );
//        System.out.println(findStudentInfo(Student::convertAgeToString, student));
        System.out.println(result1);

    }

}
