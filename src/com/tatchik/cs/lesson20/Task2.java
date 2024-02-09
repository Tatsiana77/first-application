package com.tatchik.cs.lesson20;

/**
 * Имеется число. Посчитать сумму цифр данного числа.
 */
public class Task2 {
    public static void main(String[] args) {
        int value = 12345;
        int result = sum(value);
        int result1 = sumWhile(value);
        System.out.println("sum= " + result);
        System.out.println("sumWhile = "+ result1);
    }

    private static int sumWhile(int value) {
        int result = 0;
        int currentValue = (value > 0 ? value : value * -1);
        while (currentValue > 0) {
            result += currentValue % 10;
            currentValue /= 10;
        }
        return result;
    }

    private static int sum(int value) {
        int result = 0;
        for (int currentValue = (value > 0 ? value : value * -1); currentValue > 0; currentValue /= 10) {
            result += currentValue % 10;
        }
        return result;
    }
}
