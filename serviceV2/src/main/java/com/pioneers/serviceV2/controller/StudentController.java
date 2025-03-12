package com.pioneers.serviceV2.controller;

import com.pioneers.serviceV2.model.dto.StudentDto;
import com.pioneers.serviceV2.model.entity.Student;
import com.pioneers.serviceV2.service.student.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void saveStudentApi(@Valid @RequestBody StudentDto studentDto) {
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
    public Student updateStudentApi(@Valid @RequestParam String id, @RequestBody StudentDto newStudentDto) {
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

    @GetMapping("findAllByFirstName")
    public List<StudentDto> getFirstNameApi(@RequestParam(value = "firstname") String firstName) {
        return studentService.findAllByFirstName(firstName);
    }
}
