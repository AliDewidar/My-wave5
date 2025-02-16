package com.pioneers.MySecondTaskE4_task5.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentDto {
    private String name;
    private int age;
    private String email;
    private String gender;
    private String password;
}
