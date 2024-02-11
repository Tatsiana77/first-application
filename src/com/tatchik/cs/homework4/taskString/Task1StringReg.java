package com.tatchik.cs.homework4.taskString;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1StringReg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();

        String result = removeDuplicatesAndSpaces(inputString);
        System.out.println("Result: " + result);

        scanner.close();
    }

    /**
     * Удаляет повторяющиеся символы без учета регистра и пробелы из переданной строки.
     *
     * @param input Входная строка
     * @return Строка без повторяющихся символов и пробелов в верхнем регистре
     */
    private static String removeDuplicatesAndSpaces(String input) {
        // Удаляем повторяющиеся символы без учета регистра
        String resultWithoutDuplicates = removeDuplicates(input);

        // Удаляем пробелы из результата
        String resultWithoutSpaces = removeSpaces(resultWithoutDuplicates);

        // Приводим результат к верхнему регистру
        return resultWithoutSpaces.toUpperCase();
    }

    /**
     * Удаляет повторяющиеся символы без учета регистра из переданной строки.
     *
     * @param input Входная строка
     * @return Строка без повторяющихся символов
     */
    private static String removeDuplicates(String input) {
        // Используем регулярное выражение для удаления повторяющихся символов без учета регистра
        String regex = "(?i)(.)\\1+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("$1");
    }

    /**
     * Удаляет пробелы из переданной строки.
     *
     * @param input Входная строка
     * @return Строка без пробелов
     */
    private static String removeSpaces(String input) {
        // Используем регулярное выражение для удаления пробелов
        return input.replaceAll("\\s", "");
    }

}
