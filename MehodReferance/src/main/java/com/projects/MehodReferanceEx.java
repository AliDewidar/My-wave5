package com.projects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class MehodReferanceEx {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Ahmed");
        stringList.add("Ali");
        stringList.add("Mohammed");

        MehodReferanceEx instance = new MehodReferanceEx();

        // Type-1 of Method Referance Types.(ونستدي الميثود منها instance بنعمل static النوع الأول لو الداله مش )
        stringList.forEach(x -> instance.greetMe(x)); //lamda expression
        stringList.forEach(instance::greetMe); //Method Referance

        // Type-2 of Method Referance Types.(بنستدعي الميثود بإسم الكلاس static لو الميثود )
        stringList.forEach(x -> MehodReferanceEx.greetHim(x)); //lamda expression
        stringList.forEach(MehodReferanceEx::greetHim);

        // Type-3 of Method Referance Types.
        System.out.println("My Friend List");
        stringList.stream()
                .filter(instance::isMyFriend) //(لو عندي ميثود اللي هيا isMyFriend بترجع boolean استخدم filter لان filter بترجع boolean)
                .forEach(System.out::println);


        // Type-4 of Method Referance Types.
        /*
            هنا بنستدعي method موجودة في نفس نوع العنصر اللي بنتعامل معاه
            في المثال، كل عنصر في stringList هو من نوع String
            و toLowerCase() هي method موجودة في class الـ String نفسه
        */

        stringList.forEach(x -> x.toLowerCase());
        stringList.forEach(String::toLowerCase);

        //another example
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        // lambda expression
        numbers.forEach(x -> Integer.toString(x)); //دي مينفعش اقلبها method reference عشان هيا بتاخد parameter
//        numbers.forEach(Integer::toString); // دي متنفعش

        // طريقة Method Reference
        numbers.forEach(Object::toString); //هنا استعملت كلاس الاب اللي هوا Object وجبت منه ميثود toString عشان اعرف اعمل mehtod referance

        //example ( toString لو عايزين ندمج رقم مع نص نستخدم ميثود  )
        numbers.forEach(num -> {
            String result = "رقم : " + num.toString() + " جنيه";
            System.out.println(result);
        });

        numbers.stream()
                .map(Integer::doubleValue)  // تحويل Integer إلى Double
                .forEach(System.out::println);

        // مثال آخر باستخدام Double
        List<Double> doubles = Arrays.asList(10.5, 20.7, 30.9);

        // طريقة Method Reference
        List<Integer> integers = doubles.stream()
                                .map(Double::intValue)//بتحول من double to integer
                                .toList();
        System.out.println("integers = " + integers);


                                                        //لو عندي ميثود هيا بتاخد 2 parameters
        // إنشاء BiConsumer للتعامل مع اثنين parameters
        BiConsumer<String, String> greetBiConsumer = (me, father) -> System.out.println("me = " + me + ", My father is = " + father);

        // استدعاء الميثود باستخدام lambda
        greetBiConsumer.accept("Ali", "Mohamed");

        // يمكن أيضاً استخدام method reference مع instance
        MehodReferanceEx instance1 = new MehodReferanceEx();
        BiConsumer<String, String> greetWithReference = instance1::greetMe1;
        greetWithReference.accept("Ahmed", "Mohamed");

    }

    public void greetMe(String me){
        System.out.println("me = " + me);
    }
    public void greetMe1(String me, String father){
        System.out.println("me = " + me + ", My father is = " + father);
    }

    public static void greetHim(String x){
        System.out.println("welcome, " + x);
    }
    public boolean isMyFriend(String x){
        return "Ahmed".equalsIgnoreCase(x) || "Ali".equalsIgnoreCase(x);
    }
}
