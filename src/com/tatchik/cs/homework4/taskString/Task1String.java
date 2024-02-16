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
        // Создание объекта Scanner для ввода данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Вывод  текста
        System.out.println("Enter the text: ");

        // Считывание введенной строки с клавиатуры
        String input = scanner.nextLine();

        // Проверка наличия введенного текста
        if (input != null) {
            // Удаление пробелов из введенной строки
            String withoutSpaces = removeSpaces(input);

            // Приведение строки к верхнему регистру
            String upperCase = toUpperCase(withoutSpaces);

            // Удаление повторяющихся символов из строки
            String result = removeDuplicates(upperCase);

            // Вывод результата обработки текста
            System.out.println("Результат: " + result);
        }
    }

    // Метод для удаления пробелов из строки
    private static String removeSpaces(String input) {
        // Проверка наличия строки и удаление пробелов
        return (input != null) ? input.replaceAll(" ", "") : null;
    }

    // Метод для приведения строки к верхнему регистру
    private static String toUpperCase(String input) {
        // Проверка наличия строки и приведение к верхнему регистру
        return (input != null) ? input.toUpperCase() : null;
    }

    // Метод для удаления повторяющихся символов из строки
    private static String removeDuplicates(String input) {
        // Проверка наличия строки
        if (input == null) {
            return null;
        }

        // Создание объекта StringBuilder для построения результирующей строки
        StringBuilder resultBuilder = new StringBuilder();

        // Инициализация переменной для хранения предыдущего символа
        char lastChar = '\0';

        // Перебор символов во входной строке
        for (char currentChar : input.toCharArray()) {
            // Если текущий символ не равен предыдущему, добавляем его к результату
            if (currentChar != lastChar) {
                resultBuilder.append(currentChar);
                lastChar = currentChar;
            }
        }

        // Возвращение результата в виде строки
        return resultBuilder.toString();
    }
}

