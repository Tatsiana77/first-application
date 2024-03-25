package com.tatchik.cs.homework10.regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Реализовать эмулятор сервиса поддержки в Беларуси.
 * Все жалобы клиентов хранятся в хронологическом порядке в виде текстового лог-файла следующего
 * формата (столбцы разделены через запятую):
 * - Порядковый номер клиента
 * - Дата и время звонка в ISO формате
 * - Фамилия и Имя клиента
 * - Телефон клиента
 * - Текст жалобы
 * Каждая новая жалоба идет с новой строки в лог-файле.
 * Например:
 * 1, 2021-09-13T10:15:30, Иванов Иван, +375 29 999 78 90, Не включается свет
 * 2, 2021-12-22T11:38:16, Петров Петр, +375257777765, Почему опять не работает интернет?
 * 3, 2021-12-28T06:55:24, Петров Петр, 333652193, Кто-то оборвал мне телефонный кабель
 * Задача:
 * С какой-то периодичностью (например, раз в 2 минуты) считывать все новые записи из лог-файла и отправлять их диспетчерам
 * для созвона с клиентами (ограничить количество диспетчеров, например, 2-3).
 * Созвон длится какое-то фиксированное время (например, 3-5 секунд), после чего он записывается в другой лог-файл в виде:
 * - Порядковый номер клиента с предыдущего лог файла
 * - Дата и время созвона
 * - Номер телефона клиента
 * Например:
 * 2, 2022-01-04 04:15, +375 (25) 777-77-65
 * 1, 2022-01-04 04:30, +375 (29) 999-78-90
 * 3, 2022-01-04 04:45, +375 (33) 365-21-93
 * Номера телефонов могут быть представлены по-разному, поэтому привести их к одному формату: +375 (29) 999-78-90.
 * * Желательно реализовать функционал добавления новых жалоб в конец лог-файла.
 */

public class SupportServiceEmulator {
    private static final String COMPLAINTS_FILE_PATH = "/Users/tv/IdeaProjects/first-application/resources/complaints.txt";
    private static final String CALL_LOG_FILE_PATH = "/Users/tv/IdeaProjects/first-application/resources/callLog.txt";
    private static final Pattern PHONE_PATTERN = Pattern.compile("(\\d{3})(\\d{2})(\\d{3})(\\d{2})(\\d{2})");
    private static final int MAX_DISPATCHERS = 3;

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(MAX_DISPATCHERS);

        executor.scheduleAtFixedRate(() -> {
            try {
                Path path = Paths.get(COMPLAINTS_FILE_PATH);
                List<String> lines = Files.readAllLines(path);

                lines.forEach(line -> {
                    Complaint complaint = ComplaintParser.parseComplaint(line);
                    logCall(complaint);
                });
            } catch (IOException e) {
                System.err.println("Error reading complaint file: " + e.getMessage());
            }
        }, 0, 2, TimeUnit.MINUTES);
    }

    private static void logCall(Complaint complaint) {
        String formattedPhone = formatPhoneNumber(complaint.getPhone());
        String logEntry = String.format("%d, %s, %s\n",
                complaint.getId(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                formattedPhone);

        try {
            Files.writeString(Paths.get(CALL_LOG_FILE_PATH), logEntry, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error writing to call log file: " + e.getMessage());
        }
    }

    private static String formatPhoneNumber(String phone) {
        Matcher matcher = PHONE_PATTERN.matcher(phone.replaceAll("\\D", ""));
        if (matcher.matches()) {
            return String.format("+375 (%s) %s-%s-%s", matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5));
        }
        return phone;
    }
}


