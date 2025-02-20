package com.pioneers.service.util.pattern.delegation;

public class AnimalFactory {

    public Animal getAnimal(String animal) {
        return switch (animal) {
            case "cat" -> new CatStrategy();
            case "dog" -> new DogStrategy();
            case "lion" -> new LionStrategy();
            default -> null;
        };
    }
}
