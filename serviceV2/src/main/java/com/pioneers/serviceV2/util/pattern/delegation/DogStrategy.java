package com.pioneers.serviceV2.util.pattern.delegation;

import org.springframework.stereotype.Component;

@Component("dog") // rename this bean from DogStrategy to dog
public class DogStrategy implements Animal {
    @Override
    public boolean isBird() {
        return false;
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public void drink() {
        System.out.println("Dog is drinking");
    }

    @Override
    public void makeSound() {
        System.out.println("Haw Haw Haw");
    }

    @Override
    public void make2e2h() {
        System.out.println("heeeeee7");
    }
}
