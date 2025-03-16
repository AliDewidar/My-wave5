package com.pioneers.serviceV4.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto {
    private String continent;
    private String country;
    private String city;
    private String street;
    private int buildingNumber;
    private int floor;
    private int apartmentNumber;
}
