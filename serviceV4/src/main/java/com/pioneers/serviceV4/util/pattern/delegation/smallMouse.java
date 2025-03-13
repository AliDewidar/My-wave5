package com.pioneers.serviceV4.util.pattern.delegation;

public class smallMouse extends mouseStrategy{
    @Override
    public boolean isBird() {
        return false;
    }

    @Override
    public void drink() {
        System.out.println("small mouse is drinking");
    }

    @Override
    public void makeSound() {
        System.out.println("small mouse is making sound");
    }

    @Override
    public void make2e2h() {
        System.out.println("small mouse is making 2e2h");
    }
}
