package com.pioneers.service.util;

public final class StudentValidation {

    private StudentValidation() {
        throw new IllegalStateException("StudentValidation Utility class");
    }

    public static boolean isMale(String gender) {
        return "Male".equalsIgnoreCase(gender);
    }

    public static boolean isAgeMatched(int age) {
        return age >= 18 && age <= 25;
    }
}
