package com.tatchik.cs.homework4.taskString;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

public class Task1StringReg {
    public static void main(String[] args) {
        // Создание объекта Scanner для ввода данных с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Вывод приглашения для ввода строки
        System.out.println("Введите строку: ");

        // Считывание введенной строки с клавиатуры
        String inputString = scanner.nextLine();

        // Обработка введенной строки и получение результата
        String result = processString(inputString);

        // Вывод результата обработки строки
        System.out.println("Результат: " + result);

        // Закрытие объекта Scanner
        scanner.close();
    }

    // Метод для обработки введенной строки
    private static String processString(String input) {
        // Проверка наличия строки и ее непустоты
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Удаление пробелов из введенной строки
        String resultWithoutSpaces = removeSpaces(input);

        // Удаление повторяющихся символов из строки
        String resultWithoutDuplicates = removeDuplicates(resultWithoutSpaces);

        // Приведение строки к верхнему регистру
        return toUpperCase(resultWithoutDuplicates);
    }

    // Метод для удаления пробелов из строки
    private static String removeSpaces(String input) {
        // Замена всех пробелов на пустую строку
        return input.replaceAll("\\s", "");
    }

    // Метод для удаления повторяющихся символов из строки
    private static String removeDuplicates(String input) {
        // Использование регулярного выражения для удаления повторов
        String regex = "(?i)(.)(?!\\1)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Построение результата без повторов
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group(1));
        }

        return result.toString();
    }

    // Метод для приведения строки к верхнему регистру
    private static String toUpperCase(String input) {
        // Приведение строки к верхнему регистру
        return input.toUpperCase();
    }
}
