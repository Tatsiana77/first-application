package com.tatchik.cs.homework4.taskString;

import java.util.Scanner;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

public class Task1String {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text: ");

        String inputString = scanner.nextLine();
        String result = removeDuplicates(inputString);

        System.out.println("Result: " + result);

        scanner.close();
    }

    /**
     * Удаляет повторяющиеся символы без учета регистра и пробелы из переданной строки.
     *
     * @param input Входная строка
     * @return Строка без повторяющихся символов и пробелов в верхнем регистре
     */
    private static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        StringBuilder result = new StringBuilder();
        // Инициализируем предыдущий символ нулевым символом
        char prevChar = '\0';
        for (char currentChar : input.toCharArray()) {
            // Пропускаем пробелы
            if (Character.isWhitespace(currentChar)) {
                continue;
            }
            // Приводим к верхнему регистру
            char upperCaseChar = toUpperCase(currentChar);
            // Проверяем, идет ли текущий символ после предыдущего без повторений
            if (upperCaseChar != prevChar) {
                result.append(upperCaseChar);
                prevChar = upperCaseChar;
            }
        }
        return result.toString();
    }

    /**
     * Приводит символ к верхнему регистру.
     *
     * @param inputChar Входной символ
     * @return Символ в верхнем регистру
     */
    private static char toUpperCase(char inputChar) {
        return Character.toUpperCase(inputChar);
    }
}

