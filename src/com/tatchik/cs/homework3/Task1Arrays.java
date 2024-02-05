package com.tatchik.cs.homework3;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать
 * новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * Не забывать, что всю логику приложения нужно выносить
 * в отдельные функции. main - только для тестирования написанного функционала.
 */

public class Task1Arrays {
    public static void main(String[] args) {
        int[] array = {3, 5, -6, 3, 2, -9, 0, -123};

        // Вызов функции для удаления отрицательных элементов и умножения на их длину
        int[] resultArray = processArray(array);

        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("Преобразованный массив: " + Arrays.toString(resultArray));

    }
    /**
     * Функция для удаления отрицательных элементов из массива и умножения каждого элемента на его длину.
     *
     * @param inputArray Исходный массив целых чисел
     * @return Новый массив после удаления отрицательных элементов и умножения на их длину
     */
    private static int[] processArray(int[] inputArray) {
        // Вызываем функцию для удаления отрицательных элементов
        int[] positiveArray = removeNegatives(inputArray);

        // Вызываем функцию для умножения каждого элемента на его длину
        return multiplyByLength(positiveArray);
    }

    /**
     * Функция для удаления отрицательных элементов из массива.
     *
     * @param array Исходный массив целых чисел
     * @return Новый массив без отрицательных элементов
     */
    private static int[] removeNegatives(int[] array) {
        int countPositives = 0;

        // Подсчитываем количество положительных элементов в массиве
        for (int num : array) {
            if (num >= 0) {
                countPositives++;
            }
        }

        // Создаем новый массив только с положительными элементами
        int[] positiveArray = new int[countPositives];
        int index = 0;

        for (int num : array) {
            if (num >= 0) {
                positiveArray[index] = num;
                index++;
            }
        }

        return positiveArray;
    }

    /**
     * Функция для умножения каждого элемента массива на его длину.
     *
     * @param array Исходный массив целых чисел
     * @return Новый массив после умножения каждого элемента на его длину
     */
    private static int[] multiplyByLength(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= array.length;
        }

        return array;
    }
}
