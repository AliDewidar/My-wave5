package com.pioneers.service.util.lombok;

import lombok.*;

@Data
//@ToString(exclude = "password")
//@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(of = { "userName", "age", "email" })
public class StudentLombok {
//    @ToString.Include
    @NonNull
    private String userName;
//    @ToString.Include
    @NonNull
    private int age;
    @NonNull
    private String email;
//    @ToString.Exclude
    private String gender;
//    @ToString.Exclude
    private String password;

}
