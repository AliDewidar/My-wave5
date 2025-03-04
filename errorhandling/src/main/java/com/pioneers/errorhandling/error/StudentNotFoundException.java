package com.pioneers.errorhandling.error;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true) // I added this case I extend RuntimeException
public class StudentNotFoundException extends RuntimeException {

     int code = 1001;
     String message = "Student not found";
     String details; // as long as I set the details via constructor, make the field final that I never used it via setter

    public StudentNotFoundException(String details) {
        super(details);
        this.details = details;
    }
}
