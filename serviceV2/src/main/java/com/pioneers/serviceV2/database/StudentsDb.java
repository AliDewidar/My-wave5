package com.pioneers.serviceV2.database;

import com.pioneers.serviceV2.model.entity.Student;
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
