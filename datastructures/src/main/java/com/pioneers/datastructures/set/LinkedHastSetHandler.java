package com.pioneers.datastructures.set;

import java.util.*;

public class LinkedHastSetHandler {
    /*
                     LinkedHashSet:
                     1- بتمسح التكرارات
                     2- بتحط القيم حسب ما انت مخزنها
                     3- بتسمح بال Null
    * */
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>(Arrays.asList(1,2,5,7,3,4,-2,4,null,null));
        System.out.println("set = " + set);

//        set.removeIf(element -> element == null);
//        set.removeIf(element -> Objects.isNull(element)); //lamda expression
        set.removeIf(Objects::isNull); // method reference
        System.out.println("set = " + set);

    }
}
