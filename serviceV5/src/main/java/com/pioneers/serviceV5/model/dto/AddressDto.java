package com.pioneers.serviceV5.model.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    @NotBlank(message = "Continent is required and cannot be empty")
    @Size(min = 2, max = 100, message = "Continent must be between 2 and 100 characters")
    private String continent;

    @NotBlank(message = "Country is required and cannot be empty")
    @Size(min = 2, max = 100, message = "Country must be between 2 and 100 characters")
    private String country;

    @NotBlank(message = "City is required and cannot be empty")
    @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters")
    private String city;

    @NotBlank(message = "Street is required and cannot be empty")
    @Size(min = 2, max = 100, message = "Street must be between 2 and 100 characters")
    private String street;

    @NotNull(message = "Building Number must be existed")
    @Min(value = 1, message = "Building Number must be at least with number 1")
    @Max(value = 200, message = "Building Number must be no more than number 200")
    private Integer buildingNumber;

    @NotNull(message = "Floor must be existed")
    @Min(value = 1, message = "Floor must be at least with number 1")
    @Max(value = 5, message = "Building Number must be no more than number 5")
    private Integer floor;

    @NotNull(message = "Apartment Number must be existed")
    @Min(value = 1, message = "Apartment Number must be at least with number 1")
    @Max(value = 20, message = "Apartment Number must be no more than number 20")
    private Integer apartmentNumber;

}
