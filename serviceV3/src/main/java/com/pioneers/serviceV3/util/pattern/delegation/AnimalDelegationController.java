package com.pioneers.serviceV3.util.pattern.delegation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animalDelegation")
public class AnimalDelegationController {

    private final BirdDelegator birdDelegator;
    private final AnimalDelegator animalDelegator;
    private final AnimalDelegator1 animalDelegator1;

    @Autowired
    public AnimalDelegationController(
            BirdDelegator birdDelegator,
            AnimalDelegator animalDelegator,
            AnimalDelegator1 animalDelegator1) {
        this.birdDelegator = birdDelegator;
        this.animalDelegator = animalDelegator;
        this.animalDelegator1 = animalDelegator1;
    }

    @GetMapping("printAllBirdsInfoWithDelegator")
    public void printAllBirdsInfoWithDelegatorApi() {
        birdDelegator.eat();
        System.out.println();
        birdDelegator.drink();
        System.out.println();
        birdDelegator.makeSound();
        System.out.println();
        birdDelegator.make2e2h();
        System.out.println();
        birdDelegator.fly();
    }

    @GetMapping("printAllAnimalsInfoWithDelegator")
    public void printAllAnimalsInfoWithDelegatorApi() {
        /*animalDelegator.eat();
        System.out.println();
        animalDelegator.drink();
        System.out.println();
        animalDelegator.makeSound();
        System.out.println();
        animalDelegator.make2e2h();*/
        animalDelegator.performActionsForAllAnimals();
    }

    @GetMapping("chooseAnimal")
    public void chooseAnimalApi(@RequestParam(name = "animal") String animal) {
        /*switch (animal.toLowerCase()) {
            case "lion":
                lionStrategy.eat();
                lionStrategy.drink();
                lionStrategy.makeSound();
                lionStrategy.make2e2h();
                System.out.println();
                break;
            case "cat":
                catStrategy.eat();
                catStrategy.drink();
                catStrategy.makeSound();
                catStrategy.make2e2h();
                System.out.println();
                break;
            case "dog":
                dogStrategy.eat();
                dogStrategy.drink();
                dogStrategy.makeSound();
                dogStrategy.make2e2h();
                System.out.println();
                break;
            default:
                System.out.println("Animal not found");
                break;
        }*/
        animalDelegator.performActionsForAnimal(animal);
    }

    @GetMapping("feedParticularAnimal")
    public void feedAnimalApi(@RequestParam(name = "animal") String animalStrategy) {
        animalDelegator1.feedAnimal(animalStrategy.toLowerCase());
    }
}