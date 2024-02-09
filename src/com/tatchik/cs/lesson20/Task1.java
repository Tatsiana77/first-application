package com.tatchik.cs.lesson20;
/**
 * Написать программу высчитывающую факториал введённого целого числа.
 */

public class Task1 {
    public static void main(String[] args) {
        int value = 5;
       int result = factorial(value);
        System.out.println(result);
    }
    private static int factorial(int value) {
        int result = 1;
        for (int currentValue = 1; currentValue <= value; currentValue++) {
            result *= currentValue;
        }
        return result;
    }
}
