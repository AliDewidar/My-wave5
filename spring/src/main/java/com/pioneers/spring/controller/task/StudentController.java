package com.pioneers.spring.controller.task;

import com.pioneers.spring.model.dto.Student;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final DbStudent dbStudent = DbStudent.getInstance();

    @GetMapping("/createStudent")
    public void addStuentApi(@RequestBody Student student){
        dbStudent.addStudent(student);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudentsApi(){
        return dbStudent.getAllStudents();
    }

    @GetMapping("/updateStudent/{id}")
    public void updateStudentApi(@PathVariable(value = "id") int id, @RequestBody Student updatedStudent){
        dbStudent.updateStudent(id, updatedStudent);
    }

    @GetMapping("/deleteStudent")
    public void deleteStudentApi(@RequestParam int id){
        dbStudent.deleteStudent(id);
    }

    @GetMapping("/getFirstStudent")
    public Optional<Student> getFirstStudentApi(){
        List<Student> students = dbStudent.getAllStudents();
        return students.stream().findFirst();
    }

}
