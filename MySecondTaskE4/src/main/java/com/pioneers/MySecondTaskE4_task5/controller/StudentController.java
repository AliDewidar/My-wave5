package com.pioneers.MySecondTaskE4_task5.controller;

// TODO: Create Three APIs to implements signup, login, logout for student.
//  the logged-in student can hit all APIs except save API. When he log-out, he can hit non of the below APIs.
//  Consider the SOLID principles and clean architecture that we explained.

import com.pioneers.MySecondTaskE4_task5.model.dto.StudentDto;
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

    @PostMapping("save")
    public void saveStudentApi(@RequestBody StudentDto studentDto) {
        studentService.save(studentDto);
    }

    @GetMapping("findAll")
    public List<StudentDto> getStudentApi() {
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
}
