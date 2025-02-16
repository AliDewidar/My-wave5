package com.pioneers.datastructures.arraylist;

import java.util.*;
import java.util.function.Consumer;

public class ArrayListHandler {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        System.out.println("list.size() = " + list.size()); // 4
        System.out.println("list = " + list); //(1,2,3,5)

        if (list.isEmpty()) {
            System.out.println("list is empty");
        } else {
            System.out.println("list is not empty"); // this
        }

        list.clear();
        if (list.isEmpty()) {
            System.out.println("list is empty"); //this
        } else {
            System.out.println("list is not empty");
        }
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(1);
        list.add(4);

        int number = list.get(1);
        System.out.println("number = " + number);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 5) {
                System.out.println("Found 5 at index " + i);
            }
        }

        System.out.println("list.contains(5) = " + list.contains(5));

        System.out.println("list = " + list);

        // Remove by Index
        list.remove(3);
        System.out.println("list = " + list);

        // Remove by Value
        list.remove(Integer.valueOf(3));
        System.out.println("list = " + list);

        list.set(1, 8);
        System.out.println("list = " + list);

        list.add(1, 7);
        System.out.println("list = " + list);

        List<Integer> list2 = new ArrayList<>(list);
        System.out.println("list2 = " + list2);

        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("list3 = " + list3);

        list3.addAll(list2);
        System.out.println("list3 = " + list3);

        list3.removeAll(list2);
        System.out.println("list3 = " + list3);

        list3.addAll(1, Arrays.asList(4, 5, 5, 7, 8, 4));
        System.out.println("list3 = " + list3);

        list3.retainAll(list2);
        System.out.println("list3 = " + list3);

        list3.sort(Comparator.naturalOrder());
        System.out.println("list3 = " + list3);

        list3.sort(Comparator.reverseOrder());
        System.out.println("list3 = " + list3);

        Collections.sort(list3);
        System.out.println("list3 = " + list3);
        Collections.reverse(list3);
        System.out.println("list3 = " + list3);

        // (1) Iteration with Indexed for
        for (int i = 0; i < list3.size(); i++) {
            System.out.println("list3[" + i + "] = " + list3.get(i));
        }

        // (2) Iteration with for-each
        for (Integer integer : list3) {
            System.out.println("integer = " + integer);
        }

        // (3) Iteration with Iterator
        Iterator<Integer> iterator = list3.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }

        // (4) Iteration by Collection forEach with passing a new interface
        list3.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("integer = " + integer);
            }
        });

        // Iteration by Collection forEach with Lambda Expression
        list3.forEach(element -> System.out.println("element = " + element));

        // Iteration by Collection forEach with Method Reference
        list3.forEach(System.out::println);

        // Method Reference for our own method
        list3.forEach(ArrayListHandler::isEven); //Method Reference
        list3.forEach(element->ArrayListHandler.isEven(element)); //Lambda Expression
        list3.forEach(ArrayListHandler::isOdd);
    }

    private static void isEven(Integer element) {
        if (element % 2 == 0) {
            System.out.println("element: " + element + " is even");
        }
    }
    private static void isOdd(Integer element) {
        if (element % 2 != 0) {
            System.out.println("element: " + element + " is odd");
        }
    }


}
