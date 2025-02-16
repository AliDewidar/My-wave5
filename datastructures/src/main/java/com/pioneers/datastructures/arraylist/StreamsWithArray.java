package com.pioneers.datastructures.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsWithArray {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,14,91,4,9,12,4,5,3));
        List<Integer> list2 = new ArrayList<>();

        list2.addAll(list1);

        int count = (int)list2.stream().count();
        System.out.println("count = " + count);

        list2.stream()
                .distinct()
                .limit(7)
                .sorted()
                .map(element -> element + 1)
                .filter(element -> element % 2 == 0)
//               .count() //دي متنفعش هنا عشان هيا بترجع long مش stream
                .forEach(System.out::println);

        ConsumerIntegerHandler handler = new ConsumerIntegerHandler();
        list2.forEach(handler);  // انا روحت للكلاس ده ConsumerIntegerHandler وعملت implement لل Consumr عشان كده قبل معايا  , لان ال foreach بتاخد Consumer

    }
}
