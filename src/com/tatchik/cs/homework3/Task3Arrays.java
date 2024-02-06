package com.tatchik.cs.homework3;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами,
 * только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * Пример:

 * [-4, -18]

 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]

 * [1, 9, 3]
 */

public class Task3Arrays {
    public static void main(String[] args) {
        int[] inputArray = {-4, 0, 1, 9, 0, -18, 3};

        // Вызываем функцию для разбиения массива
        int[][] resultArrays = splitArray(inputArray);

        // Выводим результаты
        System.out.println("Исходный массив: " + Arrays.toString(inputArray));
        System.out.println("Отрицательные числа: " + Arrays.toString(resultArrays[0]));
        System.out.println("Нули: " + Arrays.toString(resultArrays[1]));
        System.out.println("Положительные числа: " + Arrays.toString(resultArrays[2]));
    }

    /**
     * Функция для разбиения массива на три других: с отрицательными числами, нулями и положительными числами.
     * @param inputArray Исходный массив целых чисел
     * @return Двумерный массив, содержащий три массива: с отрицательными числами, нулями и положительными числами
     */
    public static int[][] splitArray(int[] inputArray) {
        // Вычисляем количество отрицательных, нулевых и положительных чисел в массиве
        int[] counts = countNumbers(inputArray);

        // Создаем три массива с соответствующими значениями
        int[] negativesArray = createArray(inputArray, counts[0], -1);
        int[] zerosArray = createArray(inputArray, counts[1], 0);
        int[] positivesArray = createArray(inputArray, counts[2], 1);

        // Возвращаем двумерный массив
        return new int[][]{negativesArray, zerosArray, positivesArray};
    }

    /**
     * Подсчитывает количество отрицательных, нулевых и положительных чисел в массиве.
     * @param array Массив целых чисел
     * @return Массив из трех элементов: количество отрицательных, нулевых и положительных чисел
     */
    private static int[] countNumbers(int[] array) {
        int[] counts = new int[3];

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (num < 0) {
                counts[0]++;
            } else if (num == 0) {
                counts[1]++;
            } else {
                counts[2]++;
            }
        }

        return counts;
    }

    /**
     * Создает массив чисел (отрицательных, нулевых или положительных) из исходного массива.
     *
     * @param array Массив целых чисел
     * @param size  Размер создаваемого массива
     * @param sign  Знак, определяющий тип чисел (отрицательные, нулевые или положительные)
     * @return Массив чисел (отрицательных, нулевых или положительных)
     */
    private static int[] createArray(int[] array, int size, int sign) {
        int[] resultArray = new int[size];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if ((num * sign) > 0) {
                resultArray[index++] = num;
            }
        }
        return resultArray;
    }
}
