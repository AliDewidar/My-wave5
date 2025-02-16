package com.pioneers.datastructures.map;

import java.util.*;

public class HashMapHandler {
    //create a hashmap of integer ✅
    //add 5 elements with different orders ✅
    //print the hashcode of each element ✅
    //remove an element ✅
    //add the removed element again ✅
    //iterate over keys of the map ✅
    //get the maximum key ✅
    //iterate over values of the hashmap ✅
    //iterate over key and value of the hashmap using lambda and print key and value ✅
    //check if the hashmap contains a key ✅
    //print the size of the hashmap ✅
    //clear the hashmap ✅
    //check if the hashmap is empty ✅
    //add null key and value ✅

    public static void main(String[] args) {
        //create a hashmap of integer and String ✅
        Map<Integer,String> map = new HashMap<>();

        //add 5 elements with different orders ✅
        map.put(1,"one");
        map.put(3,"three");
        map.put(2,"two");
        map.put(4,"fourfour");
        map.put(5,"five");
        map.put(4,"four"); // overrides the previous value

        System.out.println("map = " + map);
        System.out.println("----------------------");

        map.remove(2);
        System.out.println("map = " + map);
        System.out.println("----------------------");

        map.put(2,"two");
        System.out.println("map = " + map);
        System.out.println("----------------------");

        //iterate over keys of the map ✅
        Set<Integer> keysOfMap = map.keySet();
        keysOfMap.forEach(System.out::println);
        System.out.println("----------------------");

        //get the maximum key ✅
        keysOfMap.stream().max(Integer::compareTo).ifPresent(System.out::println);
        System.out.println("----------------------");

        //iterate over values of the hashmap
        Collection<String> valuesOfMap = map.values();
        valuesOfMap.forEach(System.out::println);
        System.out.println("----------------------");

        //convet from collection of string to collect it to a list
        List<String> listOfValues = map.values().stream().toList();
        listOfValues.forEach(System.out::println);
        System.out.println("----------------------");

        Set<Map.Entry<Integer,String>> entriesOfMap = map.entrySet(); // this get key and value together
        //iterate over key and value of the hashmap using enhanced for loop
        for (Map.Entry<Integer,String> entry : entriesOfMap){
            System.out.println("key = " + entry.getKey());
            System.out.println("value = " + entry.getValue());
            System.out.println();
        }
        System.out.println("----------------------");

        //iterate over key and value of the hashmap using lambda and print key and value ✅
        entriesOfMap.forEach(entry -> {
            System.out.println("key = " + entry.getKey());
            System.out.println("value = " + entry.getValue());
            System.out.println();
        });
        System.out.println("----------------------");

        if (map.containsKey(1)){
            System.out.println("map.get(1) = " + map.get(1));
        }
        System.out.println("----------------------");

        int sizeOfmap = map.size();
        System.out.println("sizeOfmap = " + sizeOfmap);
        System.out.println("------------------------");

        map.clear();
        if (map.isEmpty()){
            System.out.println("map is empty");
        }
        System.out.println("-----------------");

        //add null key and value ✅
        map.put(null,"one");
        map.put(1,null);
        System.out.println("map = " + map);

    }
}
