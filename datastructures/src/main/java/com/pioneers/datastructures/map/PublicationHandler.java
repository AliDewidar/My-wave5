package com.pioneers.datastructures.map;

import java.util.*;
import java.util.stream.Collectors;

public class PublicationHandler {

    private static final Map<String,List<Publication>> map = new HashMap<>();

    public static void main(String[] args) {


        Publication publication1 = new Publication("Protocol Conversion based on IoT Systems", "Abdelaziz", "Springer Nature Series");
        Publication publication4 = new Publication("IoT", "Abdelaziz", "Google Scholar");

        Publication publication2 = new Publication("Blockchain", "Merna", "Scopus");
        Publication publication5 = new Publication("Rust with Blockchain", "Merna", "Scopus");
        Publication publication6 = new Publication("Rust with Blockchain", "Merna", "Scopus");
        Publication publication7 = new Publication("Rust with Blockchain", "Merna", "Scopus");

        Publication publication3 = new Publication("Machine Learning", "Khaled", "Web of Science");

        List<Publication> iotPublications = new ArrayList<>(Arrays.asList(publication1,publication4));
        List<Publication> blockChainPublications = new ArrayList<>(Arrays.asList(publication2,publication5,publication6,publication7));
        List<Publication> aiPublications = new ArrayList<>(Arrays.asList(publication3));

        map.put("IoT",iotPublications);
        map.put("BlockChain",blockChainPublications);
        map.put("AI",aiPublications);

        System.out.println("map = " + map);

        // get indexation of particular publication :
        // 1- Fetch Values of publication (key)
        // 2- iterate over value (list that contains ex: publication2, publication5)
        // 3- Process each publication to get the indexation

        //with bad code
//        List<Publication> iotList = map.get("Iot");
//        List<String> iotIndexation = iotList.stream()
//                .map(publication -> {
//                    String indexation = publication.getIndexation();
//                    return indexation;
//                })
//                .collect(Collectors.toList()); //لازم هنا نعملها toset عشان مبجيبش المكرر
//        iotIndexation.forEach(System.out::println);
        System.out.println("------------------------------");

        //with best code
//        map.get("BlockChain").stream()
//                .map(Publication::getIndexation)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);

        //good code with call function
        printIndexation("IoT");
        System.out.println("------------------------");
        printIndexation("AI");
    }

    //with beautiful and best code
    public static void printIndexation(String shelveName) {
        map.get(shelveName).stream()
                .map(Publication::getIndexation)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }


}
