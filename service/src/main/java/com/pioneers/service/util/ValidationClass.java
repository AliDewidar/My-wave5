package com.pioneers.service.util;

import com.pioneers.service.model.entity.Student;

public final class ValidationClass {

    private ValidationClass() {
        throw new IllegalStateException("StudentValidation Utility class");
    }

    public static boolean isMale(String gender) {
        return "Male".equalsIgnoreCase(gender);
    }

    public static boolean isAgeMatched(int age) {
        return age >= 18 && age <= 25;
    }

    public static void checkPassword(String defult, String target) {
        if(!target.equals(defult)) {
            throw new IllegalArgumentException("Invalid password");
        }
    }

    public static void validateStudentExists(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
    }
}
