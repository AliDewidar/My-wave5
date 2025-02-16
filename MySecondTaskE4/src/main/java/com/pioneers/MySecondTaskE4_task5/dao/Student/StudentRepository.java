package com.pioneers.MySecondTaskE4_task5.dao.Student;


import com.pioneers.MySecondTaskE4_task5.model.entity.Student;

import java.util.Collection;

public interface StudentRepository {

    Collection<Student> findAll();

    Student findById(String id);

    /*    Replace this two method to (upsert) method
     *  لان الاتنين بياخدوا student ومبيرجعوش حاجة ف نعملهم في ميثود واحده افضل*/
//    void save(Student student);
//    void update(Student student);

    void upsert(Student student);

    void removeById(String id);

    Student findFirst();
}
