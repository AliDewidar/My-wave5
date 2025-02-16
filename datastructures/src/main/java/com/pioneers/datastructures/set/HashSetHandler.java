package com.pioneers.datastructures.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetHandler {
    /*
                            HashSet:
                           1- بتمسح التكررارات
 2- بترتب عشوائي معناها يعني مفيش ميثود get()
                             3-بتسمح بال Null
    * */
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,1,2,3,4));
        System.out.println("set = " + set);

        Set<Integer> set2 = new HashSet<>(set);// بياخد collection والset بتورث من collection
        System.out.println("set2 = " + set2);

        set2.remove(1); //remove by object
        System.out.println("set2 = " + set2);

        set2.clear();
        System.out.println("set2.isEmpty() = " + set2.isEmpty());

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(3);

        set2.iterator().forEachRemaining(System.out::println);
        System.out.println("-----------------------");

        Iterator<Integer> iterator = set2.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator.next() = " + iterator.next());
        }
        System.out.println("-----------------------");

        for(Integer integer : set2){
            System.out.println("integer = " + integer);
        }

        System.out.println("-----------------------");
        set2.forEach(System.out::println);

        System.out.println("-----------------------");
        Set<Integer> set3 = set2.stream()
                .map(element -> element * 2)
                .collect(Collectors.toCollection(HashSet::new));
        set3.stream()
                .filter(element -> element % 2 == 0)
                .forEach(System.out::println);

        System.out.println("-----------------------");
        Set<Integer> set4 = new HashSet<>(Arrays.asList(1,2,3,4,-2,1,3,7,null,10));
        System.out.println("set4 = " + set4);

//        set4.get(1); متعرفش تبحث لانها بترتب عشوائي

        System.out.println("-----------------------");
        // The below snippet throw a null pointer exception due to the added null value.
        set4.stream().filter(element -> element == 2)
                .findFirst().ifPresent(System.out::println);
    }
}
