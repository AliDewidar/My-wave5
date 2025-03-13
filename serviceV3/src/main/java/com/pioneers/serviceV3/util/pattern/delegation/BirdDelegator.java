package com.pioneers.serviceV3.util.pattern.delegation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BirdDelegator {

    private final List<Bird> birds;

    @Autowired
    public BirdDelegator(List<Bird> birds) {
        this.birds = birds;
    }

    public void eat() {
        birds.stream()
                .filter(Bird::isBird)
                .forEach(Bird::eat);
    }

    public void drink() {
        birds.stream()
                .filter(Bird::isBird)
                .forEach(Bird::drink);
    }

    public void makeSound() {
        birds.stream()
                .filter(Bird::isBird)
                .forEach(Bird::makeSound);
    }

    public void make2e2h() {
        birds.stream()
                .filter(Bird::isBird)
                .forEach(Bird::make2e2h);
    }

    public void fly() {
        birds.stream()
                .filter(Bird::isBird)
                .forEach(Bird::fly);
    }
}
