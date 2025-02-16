package com.pioneers.MySecondTaskE3.dao.Student;

import com.pioneers.task.task_edition_two.model.dto.StudentDto;
import com.pioneers.task.task_edition_two.model.entity.Student;
import com.pioneers.task.task_edition_two.util.factory.StudentFactory;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.pioneers.task.task_edition_two.util.factory.StudentFactory.toStudentDto;

@Component
public class StudentRepositoryImpl implements StudentRepository {

    private final Map<String, Student> students;

    private StudentRepositoryImpl() {
        //this.getClass().getSimpleName()بتجيبلي اسم الكلاس
        System.out.println("Creating [ "+ this.getClass().getSimpleName() +" ] empty constructor (Bean)");
        students = new HashMap<>();
    }

    public void save(StudentDto studentDto) {
        String id = UUID.randomUUID().toString();
        //use dependancy injecton by constructor better than setter.
        Student student = new Student(id, studentDto.getName(), studentDto.getAge(), studentDto.getEmail());
//        student.setId(id);
//        student.setName(studentDto.getName());
//        student.setAge(studentDto.getAge());
//        student.setEmail(studentDto.getEmail());
        students.put(student.getId(), student);
        System.out.println("Student saved with ID: [" + id + "] and name: [" + student.getName() + "]");
    }

    public List<StudentDto> findAll() {
        return students.values()
                .stream()
                .map(StudentFactory::toStudentDto)
                .toList();
    }

    public StudentDto findById(String id) {
        Student student = students.get(id);
        StudentDto studentDto = new StudentDto(student.getName(), student.getAge(), student.getEmail());
//        studentDto.setName(student.getName());
//        studentDto.setAge(student.getAge());
//        studentDto.setEmail(student.getEmail());
        return studentDto;
    }

    public void update(String id, StudentDto newStudentDto) {
        String oldName = students.get(id).getName();
        Student student = students.get(id);
        student.setName(newStudentDto.getName());
        student.setAge(newStudentDto.getAge());
        student.setEmail(newStudentDto.getEmail());
        students.put(id, student);
        System.out.println("Student with ID [" + id + "] and oldName ["
                + oldName + " and newName [" + student.getName() + "]");
    }

    public void removeById(String id) {
        students.remove(id);
    }

    public StudentDto findFirst() {
        String firstId = students.keySet().stream().findFirst().orElse("");

        Student student = students.get(firstId);

//        StudentDto studentDto = new StudentDto();
//        studentDto.setName(student.getName());
//        studentDto.setAge(student.getAge());
//        studentDto.setEmail(student.getEmail());

        //use dependency injection by ((constructor)) better than setter.
//        StudentDto studentDto = new StudentDto(student.getName(),student.getAge(),student.getEmail());


        //take this to method case its duplicated
        return toStudentDto(student);
    }

    // to achieve single responsibility principle we need to remove this method from here and put it in a util class
   /* public StudentDto toStudentDto(Student student){
        return new StudentDto(student.getName(),student.getAge(),student.getEmail());
    }*/
}
