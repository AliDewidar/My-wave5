package com.pioneers.MySecondTask.student;


import java.util.ArrayList;
import java.util.List;

public class DbStudent {
    private static DbStudent dbStudent;
/*
* هنا التعديل الاول هنغير الداتا بيز بتاعتنا هنخليها من نوع Map مش List
* السبب محتاج اعمل enhanced for loop عشان اجيب student بال id بتاعه
* السبب التاني ال map بتخزن key and value بسهوله اجيب اي student
* ال complexity بتاعت ال map بتاعتنا O(1) مش زي ال list O(n)
* */

/*التعديل التاني اني اخلي الobject بتاع ال studentList في constructor افضل من اني اخليه برا*/
    private static final List<Student> studentList = new ArrayList<>();

    public static DbStudent getInstance(){
        if (dbStudent == null){
            dbStudent = new DbStudent();
        }
        return dbStudent;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public void updateStudent(int id, Student updatedStudent) {
        studentList.forEach(student -> {
            if (student.getId() == id) {
                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());
                student.setEmail(updatedStudent.getEmail());
            }
        });
    }

    public void deleteStudent(int id){
        studentList.removeIf(student -> student.getId() == id);
    }
}

