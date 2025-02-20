package com.pioneers.service.util.pattern.factory.AnimalEx;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class LionStrategy implements Animal {
    @Override
    public boolean isBird() {
        return false;
    }

    @Override
    public void eat() {
        System.out.println("Lion is eating");
    }

    @Override
    public void drink() {
        System.out.println("Lion is drinking");
    }

    @Override
    public void makeSound() {
        System.out.println("roarrrrr");
    }

    @Override
    public void make2e2h() {
        System.out.println("2eeeeh");
    }
}
