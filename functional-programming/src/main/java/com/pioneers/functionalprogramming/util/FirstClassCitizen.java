package com.pioneers.functionalprogramming.util;

import com.pioneers.functionalprogramming.model.Student;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class FirstClassCitizen {
    public static void main(String[] args) {

//        IntBinaryOperator doCalculation = (num1, num2) -> num1 / num2;
//        System.out.println(doCalculation.applyAsInt(2, 0));

        int result = processBiFunction(Calculator::divide, 20, 10);
        System.out.println(result);

        IntUnaryOperator addOne = Calculator::addOne;
        IntUnaryOperator multiplyByTen = Calculator::multiplyByTen;

        int functionalResult = doCalculation(addOne, multiplyByTen, 1);

        System.out.println(functionalResult);


        FloatTripleOperator addTriple = Calculator::add;
        FloatTripleOperator subtractTriple = Calculator::subtract;
        FloatTripleOperator multiplyTriple = Calculator::multiply;

        float addedNums = addTriple.apply(1.1f, 1.2f, 1.3f);
        System.out.println(addedNums);

        float ourResult = addTriple.andThen(subtractTriple).apply(1.1f, 1.2f, 1.3f);
        System.out.println("ourResult = " + ourResult);


        Student student = Student.builder()
                .firstName("Ali")
                .lastName("Mohamed")
                .age(23)
                .email("ali.mohamed@techpioneershub.com")
                .build();

        System.out.println(findStudentInfo(Student::convertAgeToString, student));
    }

    public static float doCalculation(FloatTripleOperator doAction, float a, float b, float c) {
        return doAction.apply(a, b, c);
    }

    public static String findStudentInfo(Function<Student, String> function, Student student) {
        return function.apply(student);
    }

    public static int doCalculation(IntUnaryOperator doAction, IntUnaryOperator doNextAction, int operand) {
        return doAction.andThen(doNextAction).applyAsInt(operand);
    }

    // Create Function that accepts new function
    public static int processBiFunction(IntBinaryOperator doCalculation, int a, int b) {
        return doCalculation.applyAsInt(a, b);
    }
}
