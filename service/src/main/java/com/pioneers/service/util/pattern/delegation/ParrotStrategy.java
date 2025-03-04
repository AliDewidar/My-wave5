package com.pioneers.service.util.pattern.delegation;

import org.springframework.stereotype.Component;

@Component("parrot") // rename this bean from ParrotStrategy to parrot
public class ParrotStrategy implements Bird {
    @Override
    public boolean isBird() {
        return true;
    }

    @Override
    public void eat() {
        System.out.println("Parrot is eating");
    }

    @Override
    public void drink() {
        System.out.println("Parrot is drinking");
    }

    @Override
    public void makeSound() {
        System.out.println("wak wak wak wak");
    }

    @Override
    public void make2e2h() {
        System.out.println("Alf Mabrok 3l4an httkesi");
    }

    @Override
    public void fly() {
        System.out.println("Aaa Atir 34an ana 5atiiir");
    }
}
