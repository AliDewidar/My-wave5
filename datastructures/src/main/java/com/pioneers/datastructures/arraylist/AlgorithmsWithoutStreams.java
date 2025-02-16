package com.pioneers.datastructures.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AlgorithmsWithoutStreams {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,5,8,5,2,1,6));
        List<Integer> list2 = new ArrayList<>();

        List<Integer> subList = list.subList(1,6);
        list2.addAll(subList);
        System.out.println("list2 = " + list2);

        int maxNum = max(list2);
        System.out.println("maxNum = " + maxNum);

        List<Integer> DistinctList = distinct(list2);
        System.out.println("AfterDistinct = " + DistinctList);
        DistinctList.forEach(System.out::println);

        printNames("ali","mohamed","Ahmed");

        int countList = countList(DistinctList);
        System.out.println("countList = " + countList);

        sortList(DistinctList);
        System.out.println("DistinctList = " + DistinctList);
        
        List<Integer> limitedList = limitList(DistinctList,3);
        limitedList.forEach(System.out::println);

        addOne(limitedList);
        System.out.println("limitedList = " + limitedList);


    }

    public static int max(List<Integer> list){
        int max = Integer.MIN_VALUE;
        for(Integer element:list){
            if(element > max){
                max =  element;
            }
        }
        return max;
    }

    public static List<Integer> distinct(List<Integer> list){
        List<Integer> distinctedList = new ArrayList<>();
        list.forEach(element -> {
            if (!distinctedList.contains(element)) {
                distinctedList.add(element);
            }
        });
        return distinctedList;
    }

    //Good practice
    public static void printNames(String...names){ // names is a list now.
        for(String name : names){
            System.out.println("name = " + name);
        }
    }

    //Bad practice
//    public static void printNames(String name1, String name2 , String name3){ // names is a list now.
//        System.out.println("name1 = " + name1);
//        System.out.println("name2 = " + name2);
//        System.out.println("name3 = " + name3);
//    }

    public static int countList(List<Integer> list){
        int count = 0;
        for(Integer element : list){
            count++;
        }
        return count;
    }


    public static void sortList(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // Swap elements
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static void sorted(List<Integer> list){
        list.sort(Integer::compareTo);
    }

    public static List<Integer> limitList(List<Integer> list , int limit){
        List<Integer> limitedList = new ArrayList<>();
        for (int element = 0; element < limit; element++) {
            limitedList.add(list.get(element));
        }
        
        return limitedList;
    }

    public static void addOne(List<Integer> list){
        list.replaceAll(element -> element + 1);
    }

}
