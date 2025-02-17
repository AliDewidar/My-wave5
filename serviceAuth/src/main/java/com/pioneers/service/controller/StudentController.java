package com.pioneers.service.controller;

import com.pioneers.service.model.dto.StudentDto;
import com.pioneers.service.model.dto.StudentLoginDto;
import com.pioneers.service.model.dto.StudentResponseDto;
import com.pioneers.service.model.dto.StudentSignupDto;
import com.pioneers.service.model.entity.Student;
import com.pioneers.service.service.student.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.pioneers.service.util.Messages.*;

// TODO: Create Three APIs to implements signup, login, logout for student.
//  the logged-in student can hit all APIs except save API. When he log-out, he can hit non of the below APIs.
//  Consider the SOLID principles and clean architecture that we explained.
@Slf4j
@RestController
@RequestMapping("/api/student")
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
    public Student updateStudentApi(@RequestParam String id, @RequestBody StudentSignupDto newStudentDto) {
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
    public ResponseEntity<StudentSignupDto> signupApi(@RequestBody StudentSignupDto studentSignupDto) {
        String response = studentService.signup(studentSignupDto);
        if (!response.equals(SIGNUP_SUCCESSFUL)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(studentSignupDto);
    }

    @PostMapping("/login")
    public ResponseEntity<StudentLoginDto> loginApi(@RequestBody StudentLoginDto studentLoginDto) {
        String response = studentService.login(studentLoginDto);
        if(!response.equals(LOGIN_SUCCESSFUL)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(studentLoginDto);
    }

    @PostMapping("/logout")
    public ResponseEntity<StudentResponseDto> logoutApi(@RequestParam String userName) {
        String response = studentService.logout(userName);
        if (response.equals(LOGOUT_SUCCESSFUL)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new StudentResponseDto(LOGOUT_SUCCESSFUL));
    }
}
