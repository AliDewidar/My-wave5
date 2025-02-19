package com.pioneers.service.util.pattern.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class AddressDto {
    private String continent;
    private String country;
    private String state;
    private String city;
    private String street;
    private String zipCode;
    private int building;
    private int floor;
    private int apartment;

    /* instead of this long code we can use builder annotation to create all this code automatically ✅



    Look at this steps to build Builder Design Pattern😙 👇
    step 1: create an outer class with its fields (AddressDto)
    step 1: create a constructor that take inner class
    step 2: create a static builder method that return inner class (instead of creating new object of inner class in main class)
    step 3: create inner class with the same fields of outer class (AddressDtoBuilder)
    step 4: create a setter for each field and return this (this means inner class) to use it in chain كسلسلة ورا بعض
    step 5: create a build method that return outer class (instead of creating new object of outer class in main class)



    public AddressDto(AddressDtoBuilder builder) {
        this.continent = builder.continent;
        this.country = builder.country;
        this.state = builder.state;
        this.city = builder.city;
        this.street = builder.street;
        this.zipCode = builder.zipCode;
        this.building = builder.building;
        this.floor = builder.floor;
        this.apartment = builder.apartment;
    }

    public static AddressDtoBuilder builder(){
        return new AddressDtoBuilder();
    }

    //inner class
    public static class AddressDtoBuilder {
        private String continent;
        private String country;
        private String state;
        private String city;
        private String street;
        private String zipCode;
        private int building;
        private int floor;
        private int apartment;

        public AddressDtoBuilder continent(String continent) {
            this.continent = continent;
            return this;
        }

        public AddressDtoBuilder country(String country) {
            this.country = country;
            return this;
        }

        public AddressDtoBuilder state(String state) {
            this.state = state;
            return this;
        }

        public AddressDtoBuilder city(String city) {
            this.city = city;
            return this;
        }

        public AddressDtoBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressDtoBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public AddressDtoBuilder building(int building) {
            this.building = building;
            return this;
        }
        public AddressDtoBuilder floor(int floor) {
            this.floor = floor;
            return this;
        }

        public AddressDtoBuilder apartment(int apartment) {
            this.apartment = apartment;
            return this;
        }

        public AddressDto build() {
            return new AddressDto(this);
        }
    }*/
}
