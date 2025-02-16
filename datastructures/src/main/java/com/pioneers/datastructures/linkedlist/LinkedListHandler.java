package com.pioneers.datastructures.linkedlist;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LinkedListHandler {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);

        System.out.println("list.get(1) = " + list.get(1));
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
        System.out.println("list = " + list); //[5, 8, 4]

        list.add(1, 7);
        System.out.println("list = " + list); //[5, 7, 8, 4]

        List<Integer> list2 = new LinkedList<>(list);
        System.out.println("list2 = " + list2); //[5, 7, 8, 4]

        List<Integer> list3 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("list3 = " + list3);

        list3.addAll(list2);
        System.out.println("list3 = " + list3); // [1, 2, 3, 4, 5, 5, 7, 8, 4]

        list3.removeAll(list2); // [1, 2, 3] بيمسح اللي في list2 والمكرر منها
        System.out.println("list3 = " + list3);

        list3.addAll(1, Arrays.asList(4, 5, 5, 7, 8, 4)); //[1, 4, 5, 5, 7, 8, 4, 2, 3]
        System.out.println("list3 = " + list3);

        list3.retainAll(list2); // بيجيب المشترك ما بين الاتنين وبيجيب المكرر
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
        list3.forEach(LinkedListHandler::isEven); //Method Reference
        list3.forEach(element->LinkedListHandler.isEven(element)); //Lambda Expression
        list3.forEach(LinkedListHandler::isOdd);


        List<String> list4 = new LinkedList<>(Arrays.asList("Ali1","Mohammed","Ahmed","Ali2","yasser"));
        LinkedList<String> filteredlist = list4.stream()
                .filter(name -> name.contains("Ali"))
//                .toList(); // casting يعني متنفعش تعملها unmodifiable دي  tolist لان ميثود ال casting ومينفعش اني اعمل  addFirst اسمها LinkedList دي متنفعش لاني عاوز استخدم ميثود من نوع
                .collect(Collectors.toCollection(LinkedList::new)); //استخدمنا collect لانك تقدر تباصيلها اي حاجة collection وهترجع الحاجة اللي انت هتباصيها

        filteredlist.addFirst("Ibrahim");
        System.out.println("filteredlist = " + filteredlist);
        filteredlist.addLast("mohy");
        System.out.println("filteredlist = " + filteredlist);

        filteredlist.removeFirst();
        filteredlist.removeLast();
        System.out.println("filteredlist = " + filteredlist);


        Student student1 = new Student(1, "Ali", 23, "Male", "ali@techpioneershub.com");
        Student student2 = new Student(2, "Khaled", 30, "Male", "khaled@techpioneershub.com");
        Student student3 = new Student(3, "Anas", 23, "Male", "anas@techpioneershub.com");
        Student student4 = new Student(4, "Ghada", 24, "Female", "ghada@techpioneershub.com");
        Student student5 = new Student(5, "Rahma", 22, "Female", "rahma@techpioneershub.com");

        // Filter male students aged 25 or younger and extract only their email addresses into a LinkedList
        LinkedList<Student> students = new LinkedList<>(Arrays.asList(student1, student2, student3, student4, student5));
        LinkedList<String> filteredStudent = students.stream()
                .filter(student -> student.getAge() <= 25 && student.getGender().equalsIgnoreCase("male"))
                .map(Student::getEmail)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("filteredStudent = " + filteredStudent);

        // Convert female students aged 22 and above into new employees, transferring basic data (name, email, ID) and setting initial salary to zero
        List<Employee> filteredEmployee = students.stream()
                .filter(student -> student.getAge() >= 22 && student.getGender().equalsIgnoreCase("female"))
                .map(student -> new Employee(student.getId(), student.getName(), student.getEmail(), 0))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("filteredEmployee = " + filteredEmployee);

        // Filter courses with grade above 85% and extract only the course names into a LinkedList
        Course course1 = new Course(1, "Java", 90, "Programming", "Active");
        Course course2 = new Course(2, "Python", 75, "Programming", "Active");
        Course course3 = new Course(3, "Database", 88, "Data", "Active");
        Course course4 = new Course(4, "Networks", 95, "Infrastructure", "Active");
        Course course5 = new Course(5, "AI", 82, "Data Science", "Active");
        LinkedList<Course> courses = new LinkedList<>(Arrays.asList(course1, course2, course3, course4, course5));

        LinkedList<String> filteredCourses = courses.stream()
                .filter(course -> course.getGrade() > 85)
                .map(Course::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("filteredCourses = " + filteredCourses);



        // Convert active projects with budget over $10,000 into detailed reports, including project name, manager, budget and current status
        Project project1 = new Project(1, "Web App", "Ali",20000, "In Progress");
        Project project2 = new Project(2, "Mobile App", "Mohamed",.21000,"Planning");
        Project project3 = new Project(3, "Cloud Migration", "Ahmed" ,9000,"In Progress");
        Project project4 = new Project(4, "Security Audit", "Yassin",8000,"Completed");
        Project project5 = new Project(5, "Database Upgrade", "Amr" ,15000,"In Progress");

        LinkedList<Project> projects = new LinkedList<>(Arrays.asList(project1, project2, project3, project4, project5));
        LinkedList<ProjectReport> largeProjectReports = projects.stream()
                .filter(project -> project.getBudget() > 10000 && project.getCurrentStatus().equals("In Progress"))
                .map(project ->new ProjectReport(
                        project.getId(),
                        project.getName(),
                        project.getManager(),
                        project.getBudget(),
                        project.getCurrentStatus()
                ))
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println("largeProjectReports = " + largeProjectReports);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        numbers.stream()
                .findFirst().ifPresent(System.out::println);

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
