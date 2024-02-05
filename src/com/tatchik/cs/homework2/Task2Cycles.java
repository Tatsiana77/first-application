package com.tatchik.cs.homework2;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */

public class Task2Cycles {
    public static void main(String[] args) {
        int number1 = 4508;
        int number2 = 4700;
        int number3 = 1234567;

        int reversedNumber1 = reverseNumber(number1);
        int reversedNumber2 = reverseNumber(number2);
        int reversedNumber3 = reverseNumber(number3);

        System.out.println("Обратное число для " + number1 + "  -> " + reversedNumber1);
        System.out.println("Обратное число для " + number2 + " -> " + reversedNumber2);
        System.out.println("Обратное число для " + number3 + " -> " + reversedNumber3);
    }

    private static int reverseNumber(int number) {
        int reversed = 0;
        int power = (int) Math.log10(number); // Определение степени десяти

        while (number != 0) {
            int digit = number % 10;
            reversed += digit * Math.pow(10, power);
            number /= 10;
            power--;
        }
        return reversed;
    }
}

