package com.pioneers.service.database;

import com.pioneers.service.model.entity.Student;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Value
public class StudentsDb {

    Map<String, Student> students;

    public StudentsDb() {
        this.students = new HashMap<>();
    }
}
