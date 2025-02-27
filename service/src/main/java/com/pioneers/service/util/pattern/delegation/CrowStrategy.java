package com.pioneers.service.util.pattern.delegation;

import org.springframework.stereotype.Component;

@Component("crow")
public class CrowStrategy implements Bird {
    @Override
    public boolean isBird() {
        return true;
    }

    @Override
    public void eat() {
        System.out.println("Crow is eating");
    }

    @Override
    public void drink() {
        System.out.println("Crow is drinking");
    }

    @Override
    public void makeSound() {
        System.out.println("3aaaw 3aaaw 3aaaw");
    }

    @Override
    public void make2e2h() {
        System.out.println("Mabroook httkesi 2orayeb");
    }

    @Override
    public void fly() {
        System.out.println("Atir f el smaa w mb5f4 mn el maa2");
    }
}
