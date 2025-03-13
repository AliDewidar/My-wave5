package com.pioneers.serviceV4.util.pattern.delegation;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.pioneers.serviceV4.util.pattern.delegation.TheAnimals.*;

@Getter
@Component
public class AnimalFactory {

    private final Map<TheAnimals, Animal> animalsMap;

    public AnimalFactory() {
        this.animalsMap = new HashMap<>();
        animalsMap.put(CAT, new CatStrategy());
        animalsMap.put(DOG, new DogStrategy());
        animalsMap.put(LION, new LionStrategy());
    }

    public Animal getAnimal(TheAnimals animal) {
        return animalsMap.get(animal);
    }

    public void feedAnimal(String name) {
        TheAnimals.fromString(name).ifPresentOrElse(
                theAnimals -> {
                    Animal animal = getAnimal(theAnimals);
                    animal.eat();
                },
                () -> System.out.println("Animal not found")
        );
    }

    /*public Optional<Animal> getAnimal(String codeOfAnimal) {
        *//*to convert string to enum we use (valueOf) method
        return animalsMap.get(TheAnimals.valueOf(animal));*//*
        return animalsMap.get();
    }*/

    /*public void addAnimal() {
        animalsMap.put(CAT, new CatStrategy());
        animalsMap.put(DOG, new DogStrategy());
        animalsMap.put(LION, new LionStrategy());
    }

    public static Animal getAnimal(String animal) {
        return switch (animal) {
            case CAT -> new CatStrategy();
            case DOG -> new DogStrategy();
            case LION -> new LionStrategy();
            default -> throw new IllegalArgumentException("Animal not found");
        };
    }*/
}
