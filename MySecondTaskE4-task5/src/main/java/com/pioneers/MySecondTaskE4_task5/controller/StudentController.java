package com.pioneers.MySecondTaskE4_task5.controller;

import com.pioneers.MySecondTaskE4_task5.model.dto.*;
import com.pioneers.MySecondTaskE4_task5.model.entity.Student;
import com.pioneers.MySecondTaskE4_task5.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Public API
    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    // Auth APIs
    @PostMapping("/signup")
    public String signup(@RequestBody SignupDto signupDto) {
        return studentService.signup(signupDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        return studentService.login(loginDto);
    }

    @PostMapping("/logout")
    public String logout(@RequestBody LogoutDto logoutDto) {
        return studentService.logout(logoutDto.getStudentId());
    }

    // Protected APIs
    @GetMapping("/findAll")
    public List<StudentDto> getAllStudents(@RequestParam String studentId) {
        return studentService.findAll(studentId);
    }

    @GetMapping("getById/{id}")
    public StudentDto getStudentById(@PathVariable String id, @RequestParam String studentId) {
        return studentService.findById(id, studentId);
    }

    @PutMapping("update/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody StudentDto updateDto,
                                 @RequestParam String studentId) {
        return studentService.update(id, updateDto, studentId);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable String id, @RequestParam String studentId) {
        studentService.removeById(id, studentId);
    }

    @GetMapping("/first")
    public StudentDto getFirstStudent(@RequestParam String studentId) {
        return studentService.findFirst(studentId);
    }
}