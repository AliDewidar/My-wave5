package com.pioneers.functionalprogramming.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Calculator {

    public int add(final int a, final int b) {
        return a + b;
    }

    public float add(float a, float b) {
        return a + b;
    }

    public float add(final float a, final float b, final float c) {
        return a + b + c;
    }

    public int addOne(int a) {
        return a + 1;
    }

    public int subtract(final int a, final int b) {
        return a - b;
    }

    public float subtract(float a, float b) {
        return a - b;
    }

    public float subtract(final float a, final float b, final float c) {
        return a - b - c;
    }

    public int multiply(final int a, final int b) {
        return a * b;
    }

    public float multiply(final float a, final float b) {
        return a * b;
    }

    public float multiply(final float a, final float b, final float c) {
        return a * b * c;
    }

    public int multiplyByTen(final int a) {
        return a * 10;
    }

    public int divide(final int a, final int b) {
        return a / b;
    }

    public float divide(final float a, float b) {
        return a / b;
    }
}
