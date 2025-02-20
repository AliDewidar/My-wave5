package com.pioneers.service.util.pattern.factory.AnimalEx;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class CatStrategy implements Animal {
    @Override
    public boolean isBird() {
        return false;
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void drink() {
        System.out.println("Cat is drinking");
    }

    @Override
    public void makeSound() {
        System.out.println("Neaw Neaw Neaw");
    }

    @Override
    public void make2e2h() {
        System.out.println("meeewwwwwww");
    }
}
