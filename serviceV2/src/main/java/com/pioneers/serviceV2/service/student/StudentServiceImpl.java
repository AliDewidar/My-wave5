package com.pioneers.serviceV2.service.student;

import com.pioneers.serviceV2.dao.student.StudentRepository;
import com.pioneers.serviceV2.error.StudentNotFoundException;
import com.pioneers.serviceV2.model.dto.LoginDto;
import com.pioneers.serviceV2.model.dto.SignupDto;
import com.pioneers.serviceV2.model.dto.StudentDto;
import com.pioneers.serviceV2.model.entity.Student;
import com.pioneers.serviceV2.util.factory.StudentFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pioneers.serviceV2.util.ValidationClass.*;
import static com.pioneers.serviceV2.util.factory.NamingUtils.buildFullName;
import static com.pioneers.serviceV2.util.factory.StudentFactory.*;

@Slf4j
@Primary
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        log.debug("Creating [{}] constructor!! (bean) with injecting studentRepository",
                this.getClass().getSimpleName());
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(@NonNull StudentDto studentDto) {
            Student student = toStudent(studentDto);

            studentRepository.upsert(student);

            log.debug("Student saved into the db with id: [{}] and name: [{}]", student.getId(),
                    buildFullName(studentDto.getFirstName(), studentDto.getSecondName()));

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
        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found with id: " + id));

        StudentDto studentDto = toStudentDto(foundStudent);

        log.debug("Student found in the db with id: [{}] and name: [{}]", id,
                buildFullName(studentDto.getFirstName(),studentDto.getSecondName()));

        return studentDto;
    }

    @Override
    public Student update(final String id, final StudentDto newStudentDto) {
        String oldStudentName = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found with id: " + id))
                .getFullName();

        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found with id: " + id));
        foundStudent = updateStudent(newStudentDto, foundStudent);

        studentRepository.upsert(foundStudent);

        log.debug("Student updated in the db with id: [{}], old name: [{}] and new name: [{}]",
                id, oldStudentName, buildFullName(newStudentDto.getFirstName(), newStudentDto.getSecondName()));
        return foundStudent;
    }

    @Override
    public void removeById(final String id) {
        studentRepository.findById(id).ifPresent(student -> {
            studentRepository.removeById(id);
            log.debug("Student removed from the db with id: [{}]", id);
        });
    }

    @Override
    public StudentDto findFirst() {
        Student firstStudent = studentRepository.findFirst();
        StudentDto studentDto = toStudentDto(firstStudent);

        log.debug("Student found in the db with id: [{}] and name: [{}]", firstStudent.getId(),
                buildFullName(studentDto.getFirstName(), studentDto.getSecondName()));

        return studentDto;
    }

    @Override
    public List<StudentDto> findAllByFirstName(String firstName) {
        return studentRepository.findAllByFirstName(firstName)
                .stream()
                .map(StudentFactory::toStudentDto)
                .toList();
    }
}
