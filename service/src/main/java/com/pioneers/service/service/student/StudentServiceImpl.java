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

            log.debug("Student saved into the db with id: [{}] and name: [{}]", student.getId(), studentDto.getName());
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

        log.debug("Student found in the db with id: [{}] and name: [{}]", id, studentDto.getName());

        return studentDto;
    }

    @Override
    public Student update(final String id, final StudentDto newStudentDto) {
        String oldStudentName = studentRepository.findById(id).getName();

        Student foundStudent = studentRepository.findById(id);
        foundStudent = updateStudent(newStudentDto, foundStudent);

        studentRepository.upsert(foundStudent);

        log.debug("Student updated in the db with id: [{}], old name: [{}] and new name: [{}]",
                id, oldStudentName, newStudentDto.getName());
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

        log.debug("Student found in the db with id: [{}] and name: [{}]", firstStudent.getId(), studentDto.getName());

        return studentDto;
    }

    @Override
    public String signup(SignupDto signupDto) {
        String studentId = createRandomId();
        if (studentRepository.findById(studentId) != null) {
            throw new IllegalArgumentException("Student ID already exists");
        }

        /*Student student = new Student(
                studentId,
                signupDto.getName(),
                signupDto.getAge(),
                signupDto.getEmail(),
                signupDto.getGender(),
                signupDto.getPassword(),
                false
        );*/

        Student student = toStudent(studentId,signupDto,false);
        
        studentRepository.upsert(student);
        return "Signup successful for ID: " + student.getId();
    }

    @Override
    public String login(LoginDto loginDto) {
        Student student = studentRepository.findById(loginDto.getId());
        validateStudentExists(student);

        if (!student.getPassword().equals(loginDto.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
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

    private void validateStudentExists(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
    }
}
