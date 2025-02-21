package com.pioneers.service.util.pattern.factory.AnimalEx;

import com.pioneers.service.util.pattern.delegation.AnimalDelegator;
import com.pioneers.service.util.pattern.delegation.BirdDelegator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @GetMapping("printInfo")
    public void getAnimalApi(@RequestParam(name = "animal") String animal) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal theAnimal = animalFactory.getAnimal(animal);
        theAnimal.eat();
        theAnimal.drink();
        theAnimal.makeSound();
        theAnimal.make2e2h();
    }
}