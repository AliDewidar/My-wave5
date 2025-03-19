package com.pioneers.serviceV5.controller;

import com.pioneers.serviceV5.model.dto.StudentDto;
import com.pioneers.serviceV5.service.LiquibaseService;
import com.pioneers.serviceV5.service.student.StudentService;
import jakarta.validation.Valid;
import liquibase.exception.LiquibaseException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    @NonNull
    private final StudentService studentService;
    @NonNull
    private final LiquibaseService liquibaseService;

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
    public StudentDto getStudentByIdApi(@PathVariable UUID id) {
        return studentService.findById(id);
    }

    @GetMapping("findByEmail/{email}")
    public StudentDto getStudentByEmailApi(@PathVariable String email) {
        return studentService.findByEmail(email);
    }

    @PutMapping("update")
    public StudentDto updateStudentApi(@Valid @RequestParam UUID id, @RequestBody StudentDto newStudentDto) {
        return studentService.update(id, newStudentDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudentApi(@PathVariable UUID id) {
        studentService.removeById(id);
    }

    @DeleteMapping("deleteAll")
    public void deleteAllStudentApi() {
        studentService.deleteAll();
    }

    @GetMapping("findFirst")
    public StudentDto getFirstStudentApi() {
        return studentService.findFirst();
    }

    @PutMapping("rollback/{rollbackCount}")
    public void rollbackApi(@PathVariable int rollbackCount) throws SQLException, LiquibaseException {
        liquibaseService.rollback(rollbackCount);
    }
}
