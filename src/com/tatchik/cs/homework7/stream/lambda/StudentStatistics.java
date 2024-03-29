package com.tatchik.cs.homework7.stream.lambda;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.TreeMap;

public class StudentStatistics {
    /**
     * Преобразует список студентов в ассоциативный массив, где ключ - номер курса,
     * а значение - информация о курсе, включая среднюю оценку и отсортированный список студентов.
     *
     * @param students Список студентов для обработки.
     * @return Ассоциативный массив с информацией о курсах.
     */


    public static Map<Integer, Map<String, Object>> processStudents(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getCourseNumber,
                        TreeMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> createCourseInfo(calculateAverageGrade(list), sortStudentsByName(list))
                        )
                ));
    }

    private static double calculateAverageGrade(List<Student> students) {
        int totalGrades = students.stream()
                .flatMap(student -> student.getGrades().stream())
                .mapToInt(Integer::intValue)
                .sum();
        int totalSubjects = students.stream().mapToInt(student -> student.getGrades().size()).sum();
        return totalSubjects > 0 ? (double) totalGrades / totalSubjects : 0;
    }

    private static List<Map<String, String>> sortStudentsByName(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName))
                .map(student -> {
                    Map<String, String> studentInfo = new HashMap<>();
                    studentInfo.put("firstName", student.getFirstName());
                    studentInfo.put("lastName", student.getLastName());
                    return studentInfo;
                })
                .collect(Collectors.toList());
    }

    private static Map<String, Object> createCourseInfo(double averageGrade, List<Map<String, String>> sortedStudents) {
        Map<String, Object> result = new HashMap<>();
        result.put("averageGrade", averageGrade);
        result.put("students", sortedStudents);
        return result;
    }
}
