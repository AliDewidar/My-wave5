package com.pioneers.serviceV5.util.mapper;

import com.pioneers.serviceV5.model.dto.AddressDto;
import com.pioneers.serviceV5.model.entity.Address;
import com.pioneers.serviceV5.util.utils.Utils;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AddressMapper {
    private static String exitstingId;

    public AddressDto toAddressDto(@NonNull final Address address) {
        return AddressDto.builder()
                .continent(address.getContinent())
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .buildingNumber(address.getBuildingNumber())
                .floor(address.getFloor())
                .apartmentNumber(address.getApartmentNumber())
                .build();
    }

    public Address toAddress(@NonNull final AddressDto addressDto) {
        return Address.builder()
                .id(Utils.createRandomId())
                .continent(addressDto.getContinent())
                .country(addressDto.getCountry())
                .city(addressDto.getCity())
                .street(addressDto.getStreet())
                .buildingNumber(addressDto.getBuildingNumber())
                .floor(addressDto.getFloor())
                .apartmentNumber(addressDto.getApartmentNumber())
                .build();
    }
}
