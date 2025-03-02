package com.pioneers.MySecondTaskE3.controller;


import com.pioneers.MySecondTaskE3.dao.Student.StudentRepository;
import com.pioneers.MySecondTaskE3.model.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class studentController {

    //open extension close modification
    //طبقت المبدأ بتاع open close principle بتاع SOLID PRINCIPLES عملت interface وورثته لبقاقي ل versions وعملت inject لل interface
    //مبدأ مهم جداً عشان معدلش بإيدي كل شوية

    private final StudentRepository studentRepository;

    @Autowired
    public studentController(@Qualifier("studentRepositoryImplV2") StudentRepository studentRepository) {
        System.out.println("Creating [ "+ this.getClass().getSimpleName() +" ] empty constructor (Bean)");
        this.studentRepository = studentRepository;
    }

    @PostMapping("save")
    public void saveStudentApi(@RequestBody StudentDto studentDto) {
        studentRepository.save(studentDto);
    }

    @GetMapping("findAll")
    public Collection<StudentDto> getStudentApi() {
        //check way to get the class name of the object bean that is injected from interface
        System.out.println("Class name: [" + studentRepository.getClass().getSimpleName() + "]");
        return studentRepository.findAll();
    }

    @GetMapping("findById")
    public StudentDto getStudentByIdApi(@RequestParam String id) {
        return studentRepository.findById(id);
    }

    @PutMapping("update")
    public void updateStudentApi(@RequestParam String id, @RequestBody StudentDto newStudentDto) {
            studentRepository.update(id, newStudentDto);
    }

    @DeleteMapping("delete")
    public void deleteStudentApi(@RequestParam String id) {
        studentRepository.removeById(id);
    }

    @GetMapping("findFirst")
    public StudentDto getFirstStudentApi() {
        return studentRepository.findFirst();
    }

}
