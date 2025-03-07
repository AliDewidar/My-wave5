package com.pioneers.functionalprogramming.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        list.stream()
                .filter(Main::isEven) // 2, 4, 6, 8, 10
                .map(String::valueOf)
                .forEach(Main::printWithSpace);
    }

    public static void printWithSpace(Object number) {
        if (number instanceof String) {
            System.out.print(number + " ");
        }
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
