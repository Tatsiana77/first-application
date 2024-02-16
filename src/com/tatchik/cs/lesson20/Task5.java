package com.tatchik.cs.lesson20;
/**
 * Написать программу высчитывающую факториал введённого целого числа.
 */
public class Task5 {
    public static void main(String[] args) {
        char startChar = 'f';
        System.out.println((int) startChar);
        System.out.println('d');
        System.out.println('c');
        printLetters(startChar);
    }

    private static void printLetters(char startChar) {
        for (char currentChar = startChar;
             !isVowel(currentChar); currentChar++) {
            System.out.println(currentChar);
        }
    }

    private static boolean isVowel(char letter) {
        return letter == 'a' || letter == 'o' || letter == 'y' || letter == 'e' || letter == 'i';
    }
}
