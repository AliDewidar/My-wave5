package com.pioneers.datastructures.set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetHandler {
    /*
                    TreeSet:
                 1- بتمسح التكرارات
                 2- بترتب القيم تصاعبداً
                 3- مبتسمحش بال Null
    * */
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>(Arrays.asList(1,2,3,-1,2,5,9));
        System.out.println("set = " + set);

        set.stream().filter(element -> element == 9)
                .findFirst().ifPresent(System.out::println);

    }

}
