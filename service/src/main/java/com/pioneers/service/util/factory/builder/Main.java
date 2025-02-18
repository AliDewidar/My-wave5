package com.pioneers.service.util.factory.builder;

public class Main {
    public static void main(String[] args) {

        // old way before Builder Design Pattern (without Builder Design Pattern)
        //if more than 5 parameters use Builder Design Pattern
        //its bad practice code and hard to read case there is more than 5 parameters
        AddressDto addressDto = new AddressDto("Africa","Egypt","Cairo","New Cairo",
                "Makram Abid","123",100,1,2);
        System.out.println(addressDto);

        //lets use builder design pattern
//        AddressDto.AddressDtoBuilder addressDtoBuilder = new AddressDto.AddressDtoBuilder(); //instead of creating new object of AddressDtoBuilder (create it in class and make it static builder method)

        //insted of this line
//        AddressDto.AddressDtoBuilder addressDtoBuilder = AddressDto.builder();

        //make the code clean code
        AddressDto addressDto1 = AddressDto.builder()
                .continent("Africa")
                .country("Egypt")
                .state("Cairo")
                .city("New Cairo")
                .street("Makram Abid")
                .zipCode("123")
                .building(100)
                .floor(1)
                .apartment(2)
                .build();

//        AddressDto addressDto1 = new AddressDto(addressDtoBuilder); //instead of creating new object of AddressDto (create it in class and make it static build method)

        System.out.println(addressDto1);

    }
}
