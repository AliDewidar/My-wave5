package com.pioneers.spring.controller;

import com.pioneers.spring.config.Student;
import com.pioneers.spring.config.Student2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class welcomeStudentController {

    private final Student student;
    private final Student2 student2;

    @Autowired
    public welcomeStudentController(Student student, Student2 student2){
        this.student = student;
        this.student2 = student2;
    }

    @GetMapping("getStudentInfo")
    public Student getStudentInfoApi() {
        return student;
    }

    @GetMapping("getStudentInfo2")
    public Student2 getStudentInfoApi2() {
        return student2;
    }

    @PostMapping("changeInfo")
    public void setStudentInfoApi() {
        student.setEmail("ali.dewidar23@techpioneershub.com");
        student.setAge(24);
    }

}
