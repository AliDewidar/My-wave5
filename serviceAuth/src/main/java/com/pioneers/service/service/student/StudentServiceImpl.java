package com.pioneers.service.service.student;

import com.pioneers.service.dao.student.StudentRepository;
import com.pioneers.service.model.dto.StudentDto;
import com.pioneers.service.model.dto.StudentLoginDto;
import com.pioneers.service.model.dto.StudentSignupDto;
import com.pioneers.service.model.entity.Student;
import com.pioneers.service.util.factory.StudentFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.pioneers.service.util.Messages.*;
import static com.pioneers.service.util.StudentValidation.isAgeMatched;
import static com.pioneers.service.util.StudentValidation.isMale;
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

            log.debug("Student saved into the db with id: [{}] and name: [{}]", student.getId(), studentDto.getUserName());
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

        log.debug("Student found in the db with id: [{}] and name: [{}]", id, studentDto.getUserName());

        return studentDto;
    }

    @Override
    public Student update(final String id, final StudentSignupDto newStudentDto) {
        String oldStudentName = studentRepository.findById(id).getUserName();

        Student foundStudent = studentRepository.findById(id);
        foundStudent = updateStudent(newStudentDto, foundStudent);

        studentRepository.upsert(foundStudent);

        log.debug("Student updated in the db with id: [{}], old name: [{}] and new name: [{}]",
                id, oldStudentName, newStudentDto.getUsername());
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

        log.debug("Student found in the db with id: [{}] and name: [{}]", firstStudent.getId(), studentDto.getUserName());

        return studentDto;
    }


    @Override
    public void signup(StudentSignupDto studentSignupDto) {

        studentRepository.findByUserName(studentSignupDto.getUsername())
                .ifPresent(student -> {
                    Student newStudent = toStudent(studentSignupDto,false);
                    studentRepository.upsert(newStudent);
                });
    }

    @Override
    public String login(StudentLoginDto studentLoginDto) {

        studentRepository.findByUserName(studentLoginDto.getUserName())
                .ifPresent(student -> {
                            if (student.getPassword().equals(studentLoginDto.getPassword())
                                    || student.getUserName().equals(studentLoginDto.getUserName())) {
                                student.setLoggedIn(true);
                                studentRepository.upsert(student);
                });

    }

    @Override
    public String logout(String userName) {
       Optional<Student> student = studentRepository.findByUserName(userName);
//      if (student.isPresent()) {
//          student.get().setLoggedIn(false);
//          studentRepository.upsert(student.get());
//          return "User Logged Out Successfully";
//      }
//        return "User not found";
        if(student.isEmpty() || !student.get().isLoggedIn()){
            return "User not found";
        }
        student.get().setLoggedIn(false);
        studentRepository.upsert(student.get());
        return LOGOUT_SUCCESSFUL;
}
}