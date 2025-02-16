package com.pioneers.datastructures.arraylist;

import java.util.function.Consumer;

public class ConsumerIntegerHandler implements Consumer<Integer> {

    @Override
    public void accept(Integer integer) {
        System.out.println("integer = " + integer);
    }
}
