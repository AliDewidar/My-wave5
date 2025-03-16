package com.pioneers.serviceV4.model.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Builder
@AllArgsConstructor
@Data
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

    private AddressDto address;
}
