package com.pioneers.service.controller;

import com.pioneers.service.model.dto.LoginDto;
import com.pioneers.service.model.dto.LogoutDto;
import com.pioneers.service.model.dto.SignupDto;
import com.pioneers.service.model.dto.StudentDto;
import com.pioneers.service.model.entity.Student;
import com.pioneers.service.service.student.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: Create Three APIs to implements signup, login, logout for student.
//  the logged-in student can hit all APIs except save API. When he log-out, he can hit non of the below APIs.
//  Consider the SOLID principles and clean architecture that we explained.
@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        log.trace("Creating [{}] constructor!! (bean) with injecting studentService",
                this.getClass().getSimpleName());
        this.studentService = studentService;
    }

    @PostMapping("save")
    public void saveStudentApi(@RequestBody StudentDto studentDto) {
        studentService.save(studentDto);
    }

    @GetMapping("findAll")
    public List<StudentDto> getStudentApi() {
        log.trace("This is a proof for injecting the bean of class: {}", studentService.getClass().getSimpleName());
        return studentService.findAll();
    }

    @GetMapping("findById/{id}")
    public StudentDto getStudentByIdApi(@PathVariable String id) {
        return studentService.findById(id);
    }

    @PutMapping("update")
    public Student updateStudentApi(@RequestParam String id, @RequestBody StudentDto newStudentDto) {
        return studentService.update(id, newStudentDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudentApi(@PathVariable String id) {
        studentService.removeById(id);
    }

    @GetMapping("findFirst")
    public StudentDto getFirstStudentApi() {
        return studentService.findFirst();
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SignupDto signupDto) {
        studentService.signup(signupDto);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginDto loginDto) {
        studentService.login(loginDto);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody LogoutDto logoutDto) {
        studentService.logout(logoutDto.getStudentId());
    }
}
