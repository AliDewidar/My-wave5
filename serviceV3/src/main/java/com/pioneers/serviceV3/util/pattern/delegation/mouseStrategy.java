package com.pioneers.serviceV3.util.pattern.delegation;

public abstract class mouseStrategy implements Animal {

    //interview question?? if i want to implement the interface methods in this class but i want to implement only some of them ?
    /*in this class i just try to make it abstract to implement the methods i want ,
     and create another class extend this class and extends the rest of the methods*/

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
}
