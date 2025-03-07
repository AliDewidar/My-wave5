package com.pioneers.serviceV2.util.pattern.delegation;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public enum TheAnimals {
    /*
    if you manager asked to write a code for each animal , you should make an attribute
    and make a constructor to take it to add a code in enum*/
    CAT("ca"),
    DOG("do"),
    LION("li");

    private final String code;

    // to convert string to enum
    public static Optional<TheAnimals> fromString(String codeOfAnimal) {
        for (TheAnimals theAnimal : TheAnimals.values()) {
            if (codeOfAnimal.equalsIgnoreCase(theAnimal.getCode())) {
                return Optional.of(theAnimal);
            }
        }
        return Optional.empty();
    }

}

