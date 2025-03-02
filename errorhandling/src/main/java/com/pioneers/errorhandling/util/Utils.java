package com.pioneers.errorhandling.util;

import java.util.UUID;

public final class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }
    public static String createRandomId() {
        return UUID.randomUUID().toString();
    }
}
