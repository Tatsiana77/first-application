package com.tatchik.cs.homework4;

import java.util.Scanner;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * Посчитать сумму всех чисел из строки
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */

public class Task2String {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку с текстом: ");
        String inputString = scanner.nextLine();

        int[] digitsArray = getDigitsArray(inputString);
        int sum = calculateSumOfDigits(digitsArray);

        System.out.println("Сумма цифр: " + sum);

        scanner.close();
    }

    private static int[] getDigitsArray(String input) {
        StringBuilder digitsString = new StringBuilder();

        for (char character : input.toCharArray()) {
            if (Character.isDigit(character)) {
                digitsString.append(character);
            }
        }

        // Вызываем новый метод для преобразования строки цифр в массив цифр
        return convertStringToDigitsArray(digitsString.toString());
    }

    /**
     * Преобразует строку цифр в массив цифр.
     *
     * @param digitsString Строка цифр
     * @return Массив цифр
     */
    private static int[] convertStringToDigitsArray(String digitsString) {
        return digitsString.chars().map(Character::getNumericValue).toArray();
    }

    /**
     * Рассчитывает сумму цифр в переданном массиве целых чисел.
     *
     * @param array Массив целых чисел
     * @return Сумма цифр
     */
    private static int calculateSumOfDigits(int[] array) {
        int sum = 0;
        for (int digit : array) {
            sum += digit;
        }
        return sum;
    }
}

