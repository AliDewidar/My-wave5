package com.pioneers.serviceV4.service.student;

import com.pioneers.serviceV4.dao.student.StudentRepository;
import com.pioneers.serviceV4.error.StudentNotFoundException;
import com.pioneers.serviceV4.model.dto.StudentDto;
import com.pioneers.serviceV4.model.entity.Student;
import com.pioneers.serviceV4.util.factory.StudentFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.pioneers.serviceV4.util.factory.NamingUtils.buildFullName;
import static com.pioneers.serviceV4.util.factory.StudentFactory.*;

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

            studentRepository.save(student);

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
    public StudentDto findById(final UUID id) {
        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found with id: " + id));

        StudentDto studentDto = toStudentDto(foundStudent);

        log.debug("Student found in the db with id: [{}] and name: [{}]", id,
                buildFullName(studentDto.getFirstName(),studentDto.getSecondName()));

        return studentDto;
    }

    @Override
    public StudentDto findByEmail(String email) {
        Student foundStudent = studentRepository.findByEmail(email)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with email: " + email));
        return toStudentDto(foundStudent);
    }

    @Override
    public Student update(final UUID id, final StudentDto newStudentDto) {
        String oldStudentName = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found with id: " + id))
                .getFullName();

        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found with id: " + id));
        foundStudent = updateStudent(newStudentDto, foundStudent);

        studentRepository.save(foundStudent);

        log.debug("Student updated in the db with id: [{}], old name: [{}] and new name: [{}]",
                id, oldStudentName, buildFullName(newStudentDto.getFirstName(), newStudentDto.getSecondName()));
        return foundStudent;
    }

    @Override
    public void removeById(final UUID id) {
            studentRepository.deleteById(id);
            log.debug("Student removed from the db with id: [{}]", id);
    }

    @Override
    public StudentDto findFirst() {
        Student firstStudent = studentRepository.findFirstByOrderById()
                .orElseThrow(()-> new StudentNotFoundException("Student not found"));
        StudentDto studentDto = toStudentDto(firstStudent);

        log.debug("Student found in the db with id: [{}] and name: [{}]", firstStudent.getId(),
                buildFullName(studentDto.getFirstName(), studentDto.getSecondName()));

        return studentDto;
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
        log.debug("All students removed from the db");
    }
}
