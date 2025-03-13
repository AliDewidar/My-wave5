package com.pioneers.serviceV4.util.pattern.delegation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AnimalDelegator {

//    private final List<Animal> animals;
    private final Map<String, Animal> animalStrategies;

    @Autowired
    public AnimalDelegator(List<Animal> animals) {
//        this.animals = animals;
        this.animalStrategies = new HashMap<>();
        for (Animal animal : animals) {
            /*
             نستخدم اسم الكلاس كـ key (زي "catStrategy" أو "lionStrategy")
             بس عشان هيبقى الاسم رخم وطويل عملنا replace لكلمة Strategy
             يعني وانت بتبعت ال request هتكتب اسم الحيوان بس
            */
            String className = animal.getClass().getSimpleName().replace("Strategy", "").toLowerCase();
            animalStrategies.put(className.toLowerCase(), animal);
        }
    }

    public void performActionsForAnimal(String animalType) {
        Animal animal = animalStrategies.get(animalType.toLowerCase());
        if(animal == null) {
            System.out.println("Animal type not found: " + animalType);
            return;
        }
        animal.eat();
        animal.drink();
        animal.makeSound();
        animal.make2e2h();
    }

    public void performActionsForAllAnimals() {
        animalStrategies.values().stream()
                .filter(animal -> !animal.isBird())
                .forEach(animal -> {
                    animal.eat();
                    animal.drink();
                    animal.makeSound();
                    animal.make2e2h();
        });
    }

    /*public void eat() {
        animals.stream()
                .filter(animal -> !animal.isBird())
                .forEach(Animal::eat);
    }

    public void drink() {
        animals.stream()
                .filter(animal -> !animal.isBird())
                .forEach(Animal::drink);
    }

    public void makeSound() {
        animals.stream()
                .filter(animal -> !animal.isBird())
                .forEach(Animal::makeSound);
    }

    public void make2e2h() {
        animals.stream()
                .filter(animal -> !animal.isBird())
                .forEach(Animal::make2e2h);
    }*/
}