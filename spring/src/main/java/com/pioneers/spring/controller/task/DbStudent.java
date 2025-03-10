package com.pioneers.spring.controller.task;

import com.pioneers.spring.model.dto.Student;

import java.util.ArrayList;
import java.util.List;

public class DbStudent {
    private static DbStudent dbStudent;
    private static final List<Student> studentList = new ArrayList<>();

    public static DbStudent getInstance(){
        if (dbStudent == null){
            dbStudent = new DbStudent();
        }
        return dbStudent;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public void updateStudent(int id, Student updatedStudent) {
        studentList.forEach(student -> {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setEmail(updatedStudent.getEmail());
            }
        });
    }

    public void deleteStudent(int id){
        studentList.removeIf(student -> student.getId() == id);
    }
}

