package com.pioneers.errorhandling.service;

import com.pioneers.errorhandling.dao.StudentRepository;
import com.pioneers.errorhandling.error.StudentNotFoundException;
import com.pioneers.errorhandling.model.dto.LoginDto;
import com.pioneers.errorhandling.model.dto.SignupDto;
import com.pioneers.errorhandling.model.dto.StudentDto;
import com.pioneers.errorhandling.model.entity.Student;
import com.pioneers.errorhandling.util.factory.StudentFactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pioneers.errorhandling.util.ValidationClass.*;
import static com.pioneers.errorhandling.util.factory.NamingUtils.buildFullName;
import static com.pioneers.errorhandling.util.factory.StudentFactory.*;

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
    public void save(StudentDto studentDto) {
        if (studentDto != null && isAgeMatched(studentDto.getAge()) && isMale(studentDto.getGender())) {
            Student student = toStudent(studentDto);

            studentRepository.upsert(student);

            log.debug("Student saved into the db with id: [{}] and FullName: [{}]", student.getId(),
                    buildFullName(studentDto.getFirstName(), studentDto.getSecondName()));
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
        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(()
                -> new StudentNotFoundException("Student with id: [" + id + "] is not found in the database"));

        StudentDto studentDto = toStudentDto(foundStudent);

        log.debug("Student found in the db with id: [{}] and FullName: [{}]", id,
                buildFullName(studentDto.getFirstName(), studentDto.getSecondName()));
        return studentDto;
    }

    @Override
    public Student update(final String id, final StudentDto newStudentDto) {
        String oldStudentName = studentRepository.findById(id)
                .orElseThrow(()
                        -> new StudentNotFoundException("Student with id: [" + id + "] is not found in the database"))
                .getFullName();

        Student foundStudent = studentRepository.findById(id).orElseThrow();
        foundStudent = updateStudent(newStudentDto, foundStudent);

        studentRepository.upsert(foundStudent);

        log.debug("Student updated in the db with id: [{}], old name: [{}] and new name: [{}]",
                id, oldStudentName, buildFullName(newStudentDto.getFirstName(), newStudentDto.getSecondName()));
        return foundStudent;
    }

    @Override
    public StudentDto removeById(final String id) {
        Student removedStudent = studentRepository.removeById(id).orElseThrow(()
                -> new StudentNotFoundException("Student with id: [" + id + "] is not found in the database"));

        log.debug("Student removed from the db with id: [{}]", id);
        return toStudentDto(removedStudent);
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
    public void signup(SignupDto signupDto) {
        // create Optional<Student> in findByEmail to handle null error
        studentRepository.findByEmail(signupDto.getEmail())
                .ifPresent(student -> {
                    Student newstudent = toStudent(signupDto, false);
                    studentRepository.upsert(newstudent);
                    log.debug("Student signed up in the db with id: [{}] ", student.getId());
                });
        /*replaced this with method toStudent() in StudentFactory ✅
        Student student = new Student(
                studentId,
                signupDto.getName(),
                signupDto.getAge(),
                signupDto.getEmail(),
                signupDto.getGender(),
                signupDto.getPassword(),
                false
        );*/
    }

    @Override
    public void login(LoginDto loginDto) {
        studentRepository.findByEmail(loginDto.getEmail())
                .ifPresent(student -> {
                    if (isEmailMatched(loginDto.getEmail(),student.getEmail()) &&
                            isPasswordMatched(loginDto.getPassword(), student.getPassword())) {
                        student.setLoggedIn(true);
                        studentRepository.upsert(student);
                        log.debug("Student logged in successfully");
                    }
                });
    }

    @Override
    public void logout(String email) {
        studentRepository.findByEmail(email)
                .ifPresent(student -> {
                    student.setLoggedIn(false);
                    studentRepository.upsert(student);
                    log.debug("Student logged out successfully");
                });
    }

    @Override
    public List<StudentDto> findAllByFirstName(String firstName) {
        List<Student> filteredStudent = studentRepository.findAllByFirstName(firstName);

        return filteredStudent.stream()
                .map(StudentFactory::toStudentDto)
                .toList();
    }

}
