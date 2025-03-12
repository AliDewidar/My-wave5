package com.pioneers.serviceV2.model.entity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
public class Student {

    private String id;

    private String fullName;

    private int age;

    private String email;

    private String gender;
}
