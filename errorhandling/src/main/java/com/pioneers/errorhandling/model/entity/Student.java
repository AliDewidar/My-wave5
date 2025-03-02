package com.pioneers.errorhandling.model.entity;

import lombok.*;

@Builder
@RequiredArgsConstructor
@Data
@AllArgsConstructor
public class Student {
    @NonNull private String id;
    @NonNull private String fullName;
    @NonNull private int age;
    @NonNull private String email;
    @NonNull private String gender;
    @NonNull private String password;
    private boolean isLoggedIn;
}
