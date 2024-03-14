package com.tatchik.cs.homework8.inout;

import java.io.IOException;
import java.util.Map;

/**
 * Даны два файла в формате CSV.
 * CSV (Comma-Separated Values) файл - это обычный текстовый файл, где через запятую
 * (может использоваться и любой другой символ) перечислены значения.
 * Также может быть в первой строчке таких файлов заголовок с названием колонок.
 * Формат первого файла items-price.csv:
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 * Формат второго файла items-name.csv:
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 * Задача:
 * Считать оба CSV файла и объединить их по полю ID в один result.csv, где будут следующие поля:
 * ID,NAME,PRICE.
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах, то записать их в один файл errors.csv,
 * где будет лишь одно поле ID.
 *
 */

public class Task1 {
    public static void main(String[] args) {
        String itemsPriceFile = "/Users/tv/IdeaProjects/first-application/resources/items-price.csv";
        String itemsNameFile = "/Users/tv/IdeaProjects/first-application/resources/items-name.csv";
        String resultFile = "/Users/tv/IdeaProjects/first-application/resources/result.scv";
        String errorsFile = "/Users/tv/IdeaProjects/first-application/resources/errors.csv";

        Map<Integer, String[]> prices = null;
        try {
            prices = CSVMerger.readCsv(itemsPriceFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<Integer, String[]> names = null;
        try {
            names = CSVMerger.readCsv(itemsNameFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        CSVMerger.mergeCsv(prices, names, resultFile, errorsFile);

        System.out.println("Files merged successfully!");

    }
}
