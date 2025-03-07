package com.pioneers.serviceV2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class StudentDto {
    private String name;
    private int age;
    private String email;
    private String gender;
    private String password;
}
