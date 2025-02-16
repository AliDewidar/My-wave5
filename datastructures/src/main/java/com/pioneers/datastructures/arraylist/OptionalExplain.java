package com.pioneers.datastructures.arraylist;

import java.util.Optional;

public class OptionalExplain {
    public static void main(String[] args) {

        try {
            String myString = returnString1(null);
            if (myString != null) { //مش هيدخل هنا أصلا
                String result = returnString1(myString);
                System.out.println("result = " + result);
            }
        }
        catch (NullPointerException ex){
                System.out.println(ex);
        }

                                                                    //with optional.of()
        Optional<String> optionalOfString = Optional.of("ali");
        // best practice
        optionalOfString.ifPresent(System.out::println);

//        //bad bad bad practice
//        System.out.println("optionalOfString = " + optionalOfString.get());


                                                                    // with optional.empty()
        Optional<String> optionalEmptyString = Optional.empty();
        System.out.println(optionalEmptyString);


                                                                //with optional.ofNullable()
        Optional<String> optionalOfNullableString = returnOptionalString("Homode Ellode qalapza elloza");
        //bad bad bad practice
        System.out.println(optionalOfNullableString.get());

        //best practice
        optionalOfNullableString.ifPresent(System.out::println);

        Optional<String> optionalOfNullableStringNull = returnOptionalString(null);
        //best practice
        optionalOfNullableStringNull.ifPresent(System.out::println);

        //bad practice
        if(optionalOfNullableStringNull.isPresent()){
            System.out.println("optionalOfNullableStringNull = " + optionalOfNullableStringNull.get());
        }

        //bad bad bad practice
        //لي وحشه اوي كده عشان لو في قيمه ب null هيطلع exception
//        System.out.println("optionalOfNullableStringNull = " + optionalOfNullableStringNull.get());


        //with generic method
        genericOptionalMehod(2).ifPresent(System.out::println);

    }


    public static String returnString1(String mystring){
        if(mystring == null){
            throw new NullPointerException("Null Pointer Exception!!");
        }
        return mystring;
    }

    public static Optional<String> returnOptionalString(String mystring){
        return Optional.ofNullable(mystring);
    }

    public static<T> Optional<T> genericOptionalMehod(T value){
        return Optional.ofNullable(value);
    }

}
