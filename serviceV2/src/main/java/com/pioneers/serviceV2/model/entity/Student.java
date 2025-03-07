package com.pioneers.serviceV2.model.entity;

import lombok.*;

@Builder
@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Student {
    @NonNull private String id;
    @NonNull private String name;
    @NonNull private int age;
    @NonNull private String email;
    @NonNull private String gender;
    @NonNull private String password;
    private boolean isLoggedIn;
}
