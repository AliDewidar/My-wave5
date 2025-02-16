package com.pioneers.datastructures.arraylist;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamWithListOfClass {
    public static void main(String[] args) {
        List<Parent> parentList = new ArrayList<>();
        parentList.add(new Parent("Ali",23));
        parentList.add(new Parent("mostafa",26));
        parentList.add(new Parent("ibrahim",25));
        parentList.add(new Parent("khaled",32));
        parentList.add(new Parent("mohamed",33));

        List<Parent> filtereParent = parentList.stream()
                .filter(parent -> parent.getAge() < 30)
                .toList(); // بتخزنلي اللي هيطلع في list جديدة وال return type بتاعها listف لازم نخزنها في اسم من نوع list
        System.out.println("filtereParent = " + filtereParent);

       Optional<Parent> optionalFirstParent = filtereParent.stream().findFirst();
       // bad bad bad practice
        System.out.println("optionalFirstParent.get() = " + optionalFirstParent.get());
//        System.out.println("optionalFirstParent = " + optionalFirstParent); // ال optional بتبقى wrapped فلازم تستخدم get عشان تشيل كلمة optional اللي بتظهر في ال output

       //bad practice
       if(optionalFirstParent.isPresent()){
           System.out.println("MyoptionalFirstParent = " + optionalFirstParent.get());
       }
       //best practice
        optionalFirstParent.ifPresent(System.out::println);



        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("amgad",23));
        studentList.add(new Student("yasser",21));

//        parentList.addAll(studentList); // لازم اللي هتمرره يا يكون الاب او حاجة وراثه من الاب زي اللي عندنا دلوقتي الطالب

//        parentList.stream()
//                .forEach(System.out::println); لو هتستخدمها لوحدها في الطباعه هتبقى مكلفة
//        System.out.println("parentList = " + parentList); //دي أفضل لو هتطبع بس

        function(studentList);
        function(parentList);

    }

    public static void function (List<? super Student> list){ // الميثود دي بتقولك اللي هتمررهولي يا يكون الطالب ي حاجة الطالب بيورث منها اللي هو الاب يعني نفس فكره ميثود ال addAll()
        System.out.println("list = " + list);

    }

    public static void function1 (List<? extends Student> list){ // الميثود دي بتقولك اللي هتمررهولي يا يكون الطالب ي حاجة بتورث من الطالب
        System.out.println("list = " + list);

    }

    public static<T> void function2 (List<T> list){ // الميثود دي بتقولك مررلي اي حاجة عادي
        System.out.println("list = " + list);
    }


}
