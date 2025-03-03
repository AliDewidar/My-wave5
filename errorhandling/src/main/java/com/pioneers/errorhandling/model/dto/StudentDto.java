package com.pioneers.errorhandling.model.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    @NotBlank(message = "First name is required and cannot be empty")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    private String firstName;

    @NotBlank(message = "Second name is required and cannot be empty")
    @Size(min = 2, max = 20, message = "Second name must be between 2 and 20 characters")
    private String secondName;

    @NotNull(message = "Age is required and cannot be empty")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 25 , message = "Age must be at most 25")
    private int age;

    @NotBlank(message = "Gender is required and cannot be empty")
    @Pattern(regexp = "^(male|m)$", message = "Gender must be either 'male' or 'm'")
    private String gender;

    @NotBlank(message = "Email is required and cannot be empty")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required and cannot be empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Phone is required and cannot be empty")
    @Pattern(regexp = "^\\+201[0-2,5]\\d{8}$", message = "Phone number is not Egyptian number and not valid")
    private String phone;

    @NotBlank(message = "Enrollment date is required and cannot be empty")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Enrollment date must be in the format yyyy-MM-dd")
    private String enrollmentDate;
}
