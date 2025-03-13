package com.pioneers.serviceV3.util.pattern.delegation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class DbOfDelegator {
//    private final List<Animal> animals;
    private final Map<String, Animal> animalsMap;

    /*if i want to use this list of animals in constuctor scope only ,
        inject it in constructor and use it insted of initialization in class scope*/
    public DbOfDelegator(ApplicationContext applicationContext, List<Animal> animals) {
//        this.animals = animals;
       /* animals.stream()
                .filter(DbOfDelegator::isAnimal)
                .forEach(animal -> {
                    animalsMap.put(animal.getClass().getSimpleName(), animal);
                    log.debug("Inserted {} to HashMap", animal.getClass().getSimpleName());
                });*/
        animalsMap = animals.stream()
                .filter(DbOfDelegator::isAnimal)
                .collect(Collectors.toMap(
                        /* insted of getting the animalStrategy such as catStrategy , i rename all beans without Strategy word such as cat , dog , lion , etc*/
//                        animal -> animal.getClass().getSimpleName(),
                        animal -> applicationContext.getBeanNamesForType(animal.getClass())[0],
                        animal -> animal
                ));


    }

    private static boolean isAnimal(Animal animal) {
        return !animal.isBird();
    }

    //this method is built after the class is initialized this is seem like a constructor but constructor is better
    /*@PostConstruct
    public void insertAnimal() {
        animals.stream()
                .filter(animal -> !animal.isBird())
                .forEach(animal -> {
                    animalsMap.put(animal.getClass().getSimpleName(), animal);
                    log.debug("Inserted {} to HashMap", animal.getClass().getSimpleName());
                });
    }*/

    public Animal getAnimal(String animalStrategy) {
        return animalsMap.get(animalStrategy);
    }
}
