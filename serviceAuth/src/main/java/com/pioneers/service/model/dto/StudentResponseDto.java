package com.pioneers.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentResponseDto {
    private String message;
    public StudentResponseDto(String message) {
        this.message = message;
    }
}
