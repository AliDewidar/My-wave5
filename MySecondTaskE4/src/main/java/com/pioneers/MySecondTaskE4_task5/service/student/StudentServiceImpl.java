package com.pioneers.MySecondTaskE4_task5.service.student;


import com.pioneers.MySecondTaskE4_task5.dao.Student.StudentRepository;
import com.pioneers.MySecondTaskE4_task5.model.dto.StudentDto;
import com.pioneers.MySecondTaskE4_task5.model.entity.Student;
import com.pioneers.MySecondTaskE4_task5.util.factory.StudentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pioneers.MySecondTaskE4_task5.util.factory.StudentFactory.*;
import static com.pioneers.MySecondTaskE4_task5.util.factory.StudentValidation.isAgeMatched;
import static com.pioneers.MySecondTaskE4_task5.util.factory.StudentValidation.isMale;

@Primary
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(StudentDto studentDto) {
        if (studentDto != null && isAgeMatched(studentDto.getAge()) && isMale(studentDto.getGender())) {
            Student student = toStudent(studentDto);
            studentRepository.upsert(student);
        }
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(StudentFactory::toStudentDto)
                .toList();
    }

    @Override
    public StudentDto findById(final String id) {
        Student foundStudent = studentRepository.findById(id);

        StudentDto studentDto = toStudentDto(foundStudent);

        return studentDto;
    }

    @Override
    public Student update(final String id, final StudentDto newStudentDto) {
        String oldStudentName = studentRepository.findById(id).getName();

        Student foundStudent = studentRepository.findById(id);
        foundStudent = updateStudent(newStudentDto,foundStudent);

        studentRepository.upsert(foundStudent);

        return foundStudent;
    }

    @Override
    public void removeById(final String id) {
        studentRepository.removeById(id);
    }

    @Override
    public StudentDto findFirst() {
        Student firstStudent = studentRepository.findFirst();
        StudentDto studentDto = toStudentDto(firstStudent);

        return studentDto;
    }
}
