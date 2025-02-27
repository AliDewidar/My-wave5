package com.pioneers.service.util.pattern.delegation;

import org.springframework.stereotype.Component;

@Component
public class AnimalDelegator1 {

    //this class enhanced from AnimalDelegator , i refactor it to put a database , and enhance forloop to stream and filter and forEach in DbOfDelegator class
    private final DbOfDelegator dbOfDelegator;

    public AnimalDelegator1(DbOfDelegator dbOfDelegator) {
        this.dbOfDelegator = dbOfDelegator;
    }
    public void feedAnimal(String animalStrategy) {
        Animal animal = dbOfDelegator.getAnimal(animalStrategy);
        animal.eat();
    }
}
