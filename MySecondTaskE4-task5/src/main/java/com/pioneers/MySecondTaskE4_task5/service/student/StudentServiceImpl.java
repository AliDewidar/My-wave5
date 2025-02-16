package com.pioneers.MySecondTaskE4_task5.service.student;

import com.pioneers.MySecondTaskE4_task5.dao.Student.StudentRepository;
import com.pioneers.MySecondTaskE4_task5.model.dto.*;
import com.pioneers.MySecondTaskE4_task5.model.entity.Student;
import com.pioneers.MySecondTaskE4_task5.util.factory.StudentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pioneers.MySecondTaskE4_task5.util.factory.StudentFactory.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public String save(StudentDto studentDto) {
        Student student = toStudent(studentDto);
        studentRepository.upsert(student);
        return "Student saved with ID: " + student.getId();
    }

    @Override
    public String signup(SignupDto signupDto) {
        if (studentRepository.findById(signupDto.getId()) != null) {
            throw new IllegalArgumentException("Student ID already exists");
        }

        Student student = new Student(
                signupDto.getId(),
                signupDto.getName(),
                signupDto.getAge(),
                signupDto.getEmail(),
                signupDto.getGender(),
                signupDto.getPassword(),
                false
        );
        studentRepository.upsert(student);
        return "Signup successful for ID: " + student.getId();
    }

    @Override
    public String login(LoginDto loginDto) {
        Student student = studentRepository.findById(loginDto.getId());
        validateStudentExists(student);

        if (!student.getPassword().equals(loginDto.getPassword())) {
            throw new SecurityException("Invalid credentials");
        }

        student.setLoggedIn(true);
        studentRepository.upsert(student);
        return "Login successful for ID: " + student.getId();
    }

    @Override
    public String logout(String studentId) {
        Student student = studentRepository.findById(studentId);
        validateStudentExists(student);

        student.setLoggedIn(false);
        studentRepository.upsert(student);
        return "Logout successful for ID: " + studentId;
    }

    // Protected operations
    @Override
    public List<StudentDto> findAll(String studentId) {
        validateLoggedIn(studentId);
        return studentRepository.findAll().stream()
                .map(StudentFactory::toStudentDto)
                .toList();
    }

    @Override
    public StudentDto findById(String id, String studentId) {
        validateLoggedIn(studentId);
        return toStudentDto(studentRepository.findById(id));
    }

    @Override
    public Student update(String id, StudentDto updateDto, String studentId) {
        validateLoggedIn(studentId);
        Student existing = studentRepository.findById(id);
        Student updated = updateStudent(updateDto, existing);
        studentRepository.upsert(updated);
        return updated;
    }

    @Override
    public void removeById(String id, String studentId) {
        validateLoggedIn(studentId);
        studentRepository.removeById(id);
    }

    @Override
    public StudentDto findFirst(String studentId) {
        validateLoggedIn(studentId);
        return toStudentDto(studentRepository.findFirst());
    }

    private void validateLoggedIn(String studentId) {
        Student student = studentRepository.findById(studentId);
        validateStudentExists(student);

        if (!student.isLoggedIn()) {
            throw new SecurityException("User not logged in");
        }
    }

    private void validateStudentExists(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
    }
}