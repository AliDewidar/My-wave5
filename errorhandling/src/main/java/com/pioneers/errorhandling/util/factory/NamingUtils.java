package com.pioneers.errorhandling.util.factory;

import com.pioneers.errorhandling.model.dto.StudentDto;
import com.pioneers.errorhandling.model.entity.Student;

public final class NamingFactory {
    private NamingFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static String buildFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static String extractFirstName(String fullName) {
        return fullName.split(" ")[0];
    }
}
