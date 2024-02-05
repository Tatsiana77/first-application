package com.tatchik.cs.homework3;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа
 * (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * Далее определить среднее арифметическое всех элементов целочисленного массива
 * и вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */

public class Task2Arrays {
    public static void main(String[] args) {
        char[] charArray = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};

        int[] intArray = convertToIntegerArray(charArray);
        double average = calculateAverage(intArray);
        printElementsAboveAverage(intArray, average);

    }

    /**
     * Метод для преобразования массива символов в массив целых чисел (коды символов).
     *
     * @param charArray Массив символов
     * @return Массив целых чисел
     */
    private static int[] convertToIntegerArray(char[] charArray) {
        int[] intArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = (int) charArray[i];
        }

        return intArray;
    }

    /**
     * Метод для расчета среднего арифметического элементов массива.
     *
     * @param intArray Массив целых чисел
     * @return Среднее арифметическое
     */
    private static double calculateAverage(int[] intArray) {
        int sum = 0;

        for (int num : intArray) {
            sum += num;
        }

        return (double) sum / intArray.length;
    }

    /**
     * Метод для вывода элементов массива, которые больше заданного значения.
     *
     * @param intArray  Массив целых чисел
     * @param threshold Значение, сравниваемое с элементами массива
     */
    private static void printElementsAboveAverage(int[] intArray, double threshold) {
        System.out.println("Среднее арифметическое: " + threshold);
        System.out.print("Элементы, больше среднего арифметического: ");

        for (int num : intArray) {
            if (num > threshold) {
                System.out.print(num + " ");
            }
        }
    }
}
