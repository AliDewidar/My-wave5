package com.pioneers.errorhandling.error;

import com.pioneers.errorhandling.model.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> handleException(MethodArgumentNotValidException e) {
        List<ErrorResponse> errorResponseList = new ArrayList<>();

        e.getBindingResult().getAllErrors().forEach(error -> {
            ErrorResponse errorResponse = new ErrorResponse(1000, ((FieldError) error).getField(), error.getDefaultMessage());
            errorResponseList.add(errorResponse);
        });

        return new ResponseEntity<>(errorResponseList, HttpStatus.BAD_REQUEST);
    }

}
