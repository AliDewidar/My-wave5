package com.pioneers.serviceV5.util.utils;

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

    public static boolean isPasswordMatched(String sourcePassword, String targetPassword) {
        return targetPassword.equals(sourcePassword);
    }

    public static boolean isEmailMatched(String sourceEmail, String targetEmail) {
        return targetEmail.equals(sourceEmail);
    }
}
