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

        int evenCount = countEvenDigits(number);
        int oddCount = countOddDigits(number);

        System.out.println("Четные цифры: " + evenCount);
        System.out.println("Нечетные цифры: " + oddCount);
    }

    // Функция для подсчета нечетных цифр
    private static int countOddDigits(int number) {
        int oddCount = 0;
        for (int currentDigit = 0; number > 0; number /= 10) {
            currentDigit = number % 10;
            if (currentDigit % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount;
    }

    // Функция для подсчета четных цифр
    private static int countEvenDigits(int number) {
        int evenCount = 0;

        for (int currentDigit = 0; number > 0; number /= 10) {
            currentDigit = number % 10;
            if (currentDigit % 2 == 0) {
                evenCount++;
            }
        }
        return evenCount;
    }
}
