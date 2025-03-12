package com.pioneers.serviceV2.util.factory;

public final class NamingUtils {
    private NamingUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static String buildFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public static String extractFirstName(String fullName) {
        return fullName.split(" ")[0];
    }

    public static String extractSecondName(String fullName) {
        return fullName.split(" ")[1];
    }

    public static boolean isNameMatched(String originalName, String targetName) {
        return originalName.equalsIgnoreCase(targetName);
    }
}
