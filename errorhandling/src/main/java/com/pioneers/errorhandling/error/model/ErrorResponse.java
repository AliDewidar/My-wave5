package com.pioneers.errorhandling.error.model;

// as long as the class is immutable that I will not set in setter method , make the class record
public record ErrorResponse(
        int code,
        String message,
        String details
) {}
