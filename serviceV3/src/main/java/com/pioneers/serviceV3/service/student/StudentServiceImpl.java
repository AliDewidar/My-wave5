package com.pioneers.serviceV3.service.student;

import com.pioneers.serviceV3.dao.student.StudentRepository;
import com.pioneers.serviceV3.error.StudentNotFoundException;
import com.pioneers.serviceV3.model.dto.StudentDto;
import com.pioneers.serviceV3.model.entity.Student;
import com.pioneers.serviceV3.util.factory.StudentFactory;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.pioneers.serviceV3.util.factory.NamingUtils.buildFullName;
import static com.pioneers.serviceV3.util.factory.StudentFactory.*;

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
    public StudentDto update(final UUID id, final StudentDto newStudentDto) {
        String oldStudentName = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found with id: " + id))
                .getFullName();

        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Student not found with id: " + id));

        studentRepository.update(foundStudent);

        log.debug("Student updated in the db with id: [{}], old name: [{}] and new name: [{}]",
                id, oldStudentName, buildFullName(newStudentDto.getFirstName(), newStudentDto.getSecondName()));
        return toStudentDto(foundStudent);
    }

    @Override
    public void removeById(final UUID id) {
            studentRepository.removeById(id);
            log.debug("Student removed from the db with id: [{}]", id);
    }

    @Override
    public StudentDto findFirst() {
        Student firstStudent = studentRepository.findFirst()
                .orElseThrow(()-> new StudentNotFoundException("Student not found"));
        StudentDto studentDto = toStudentDto(firstStudent);

        log.debug("Student found in the db with id: [{}] and name: [{}]", firstStudent.getId(),
                buildFullName(studentDto.getFirstName(), studentDto.getSecondName()));

        return studentDto;
    }
}
