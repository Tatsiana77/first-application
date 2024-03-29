package com.tatchik.cs.homework2;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число,
 * а возвращать количество четных цифр (вторая функция - нечетных).
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1Cycles {
    public static void main(String[] args) {
        int number = 228910;

        int evenCount = countDigits(number, true);
        int oddCount = countDigits(number, false);

        System.out.println("Четные цифры: " + evenCount);
        System.out.println("Нечетные цифры: " + oddCount);
    }

    // Функция для подсчета нечетных цифр
    private static int countDigits(int number, boolean isEven) {
        int count = 0;

        for (int currentDigit = 0; number > 0; number /= 10) {
            currentDigit = number % 10;
            if ((isEven && isEven(currentDigit)) || (!isEven && !isEven(currentDigit))) {
                count++;
            }
        }
        return count;
    }
    // Функция для проверки четности
    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
