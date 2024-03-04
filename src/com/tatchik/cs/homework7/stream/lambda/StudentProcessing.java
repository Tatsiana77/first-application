package com.tatchik.cs.homework7.stream.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */

public class StudentProcessing {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Иван", "Иванов", 1, Arrays.asList(4, 5, 3)),
                new Student("Алиса", "Кузнецова", 2, Arrays.asList(5, 4, 5)),
                new Student("Василий", "Петренко", 1, Arrays.asList(3, 2, 4)),
                new Student("Ева", "Стрельцова", 2, Arrays.asList(5, 5, 5)),
                new Student("Андрей", "Романов", 3, Arrays.asList(4, 3, 4))
        );

        Map<Integer, Map<String, Object>> result = StudentStatistics.processStudents(students);

        result.forEach((course, data) -> {
            System.out.println("Курс: " + course);
            System.out.println("Средняя оценка: " + data.get("averageGrade"));
            System.out.println("Студенты: " + data.get("students"));
            System.out.println("---");
        });
    }
}
