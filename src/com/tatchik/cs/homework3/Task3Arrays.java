package com.tatchik.cs.homework3;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
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

        int[][] resultArrays = splitArray(inputArray);

        System.out.println("Исходный массив: " + Arrays.toString(inputArray));
        System.out.println("Отрицательные числа: " + Arrays.toString(resultArrays[0]));
        System.out.println("Нули: " + Arrays.toString(resultArrays[1]));
        System.out.println("Положительные числа: " + Arrays.toString(resultArrays[2]));
    }

    /**
     * Функция для разбиения массива на три других: с отрицательными числами, нулями и положительными числами.
     *
     * @param inputArray Исходный массив целых чисел
     * @return Двумерный массив, содержащий три массива: с отрицательными числами, нулями и положительными числами
     */
    public static int[][] splitArray(int[] inputArray) {
        int countNegatives = countNegatives(inputArray);
        int countZeros = countZeros(inputArray);
        int countPositives = countPositives(inputArray);

        int[] negativesArray = createNegativesArray(inputArray, countNegatives);
        int[] zerosArray = createZerosArray(inputArray, countZeros);
        int[] positivesArray = createPositivesArray(inputArray, countPositives);

        return new int[][]{negativesArray, zerosArray, positivesArray};
    }

    /**
     * Подсчитывает количество отрицательных чисел в массиве.
     * @param array Массив целых чисел
     * @return Количество отрицательных чисел
     */
    private static int countNegatives(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num < 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Подсчитывает количество нулевых чисел в массиве.
     * @param array Массив целых чисел
     * @return Количество нулевых чисел
     */
    private static int countZeros(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num == 0) {
                count++;
            }
        }
        return count;
    }
    /**
     * Подсчитывает количество положительных чисел в массиве.
     * @param array Массив целых чисел
     * @return Количество положительных чисел
     */
    private static int countPositives(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num > 0) {
                count++;
            }
        }
        return count;
    }
    /**
     * Создает массив отрицательных чисел из исходного массива.
     * @param array Массив целых чисел
     * @param size  Размер создаваемого массива
     * @return Массив отрицательных чисел
     */
    private static int[] createNegativesArray(int[] array, int size) {
        int[] negativesArray = new int[size];
        int index = 0;
        for (int num : array) {
            if (num < 0) {
                negativesArray[index++] = num;
            }
        }
        return negativesArray;
    }
    /**
     * Создает массив нулевых чисел из исходного массива.
     * @param array Массив целых чисел
     * @param size  Размер создаваемого массива
     * @return Массив нулевых чисел
     */
    private static int[] createZerosArray(int[] array, int size) {
        int[] zerosArray = new int[size];
        int index = 0;
        for (int num : array) {
            if (num == 0) {
                zerosArray[index++] = num;
            }
        }
        return zerosArray;
    }
    /**
     * Создает массив положительных чисел из исходного массива.
     * @param array Массив целых чисел
     * @param size  Размер создаваемого массива
     * @return Массив положительных чисел
     */
    private static int[] createPositivesArray(int[] array, int size) {
        int[] positivesArray = new int[size];
        int index = 0;
        for (int num : array) {
            if (num > 0) {
                positivesArray[index++] = num;
            }
        }
        return positivesArray;
    }
}
