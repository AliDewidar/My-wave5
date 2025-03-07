package com.pioneers.serviceV2.util.pattern.delegation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animalFactory")
public class AnimalFactoryController {

    private final AnimalFactory animalFactory;

    @Autowired
    public AnimalFactoryController(AnimalFactory animalFactory) {
        this.animalFactory = animalFactory;
    }

    @GetMapping("printInfo")
    public void getAnimalApi(@RequestParam(name = "animal") String animal) {
//        Animal theAnimal = animalFactory.getAnimal(animal);
//        theAnimal.eat();
//        theAnimal.drink();
//        theAnimal.makeSound();
//        theAnimal.make2e2h();
    }

    @GetMapping("feedAnimal")
    public void feedAnimal(@RequestParam(name = "animal") String animal) {
        animalFactory.feedAnimal(animal);
    }
}