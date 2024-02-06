package com.tatchik.cs.homework2;

public class Task1CyclesNew {
    public static void main(String[] args) {
        int number = 228910;

        int evenCount = countDigits(number, true);
        int oddCount = countDigits(number, false);

        System.out.println("Четные цифры: " + evenCount);
        System.out.println("Нечетные цифры: " + oddCount);
    }

    // Функция для подсчета четных и нечетных цифр
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


