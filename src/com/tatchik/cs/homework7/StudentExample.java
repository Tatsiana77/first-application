package com.tatchik.cs.homework7;

import com.tatchik.cs.homework7.stream.lambda.Student;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class StudentExample {
    /**
 * Преобразует список студентов в ассоциативный массив, где ключ - номер курса,
 * а значение - информация о курсе, включая среднюю оценку и отсортированный список студентов.
 *
 * @param students Список студентов для обработки.
 * @return Ассоциативный массив с информацией о курсах.
 */
public static Map<Integer, Map<String, Object>> processStudents(List<Student> students) {
    TreeMap<Integer, Map<String, Object>> collect = students.stream()
            .collect(Collectors.groupingBy( // Группировка по номеру курса
                    Student::getCourseNumber, // Ключ группировки - номер курса
                    TreeMap::new, // Используем TreeMap для сортировки по ключу (номеру курса)
                    Collectors.collectingAndThen( // После сбора элементов группы
                            Collectors.toList(), // Собираем студентов в список
                            list -> {
                                // Вычисление средней оценки всех студентов на курсе
                                double averageGrade = list.stream()
                                        .flatMap(student -> student.getGrades().stream())
                                        .mapToInt(Integer::intValue)
                                        .average()
                                        .orElse(0);

                                // Сортировка студентов по имени и фамилии
                                List<Map<String, String>> sortedStudents = list.stream()
                                        .sorted(Comparator.comparing(Student::getFirstName)
                                                .thenComparing(Student::getLastName))
                                        .map(student -> {
                                            // Создание информации о студенте с полями Имя и Фамилия
                                            Map<String, String> studentInfo = new HashMap<>();
                                            studentInfo.put("firstName", student.getFirstName());
                                            studentInfo.put("lastName", student.getLastName());
                                            return studentInfo;
                                        })
                                        .collect(Collectors.toList());

                                // Формирование результирующей информации для курса
                                Map<String, Object> result = new HashMap<>();
                                result.put("averageGrade", averageGrade);
                                result.put("students", sortedStudents);

                                return result;
                            }
                    )
            ));
    return collect;
}
}
