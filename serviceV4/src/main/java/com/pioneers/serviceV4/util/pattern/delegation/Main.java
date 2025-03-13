package com.pioneers.serviceV4.util.pattern.delegation;

public class Main {
    public static void main(String[] args) {
        String name = "do";
        AnimalFactory animalFactory = new AnimalFactory();
        animalFactory.feedAnimal(name);

    }


}
