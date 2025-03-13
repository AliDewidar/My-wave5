package com.pioneers.service.service.student;

import com.pioneers.service.dao.student.StudentRepository;
import com.pioneers.service.model.dto.LoginDto;
import com.pioneers.service.model.dto.SignupDto;
import com.pioneers.service.model.dto.StudentDto;
import com.pioneers.service.model.entity.Student;
import com.pioneers.service.util.factory.StudentFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pioneers.service.util.ValidationClass.*;
import static com.pioneers.service.util.factory.StudentFactory.*;

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

            log.debug("Student saved into the db with id: [{}] and name: [{}]", student.getId(), studentDto.getFirstName());
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

        log.debug("Student found in the db with id: [{}] and name: [{}]", id, studentDto.getFirstName());

        return studentDto;
    }

    @Override
    public Student update(final String id, final StudentDto newStudentDto) {
        String oldStudentName = studentRepository.findById(id).getName();

        Student foundStudent = studentRepository.findById(id);
        foundStudent = updateStudent(newStudentDto, foundStudent);

        studentRepository.upsert(foundStudent);

        log.debug("Student updated in the db with id: [{}], old name: [{}] and new name: [{}]",
                id, oldStudentName, newStudentDto.getFirstName());
        return foundStudent;
    }

    @Override
    public void removeById(final String id) {
        studentRepository.removeById(id);
        log.debug("Student removed from the db with id: [{}]", id);
    }

    @Override
    public StudentDto findFirst() {
        Student firstStudent = studentRepository.findFirst();
        StudentDto studentDto = toStudentDto(firstStudent);

        log.debug("Student found in the db with id: [{}] and name: [{}]", firstStudent.getId(), studentDto.getFirstName());

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

}
