package com.tatchik.cs.homework10.regex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


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
    private static final int MAX_DISPATCHERS = 3;
    private static final String COMPLAINTS_FILE_PATH = "/Users/tv/IdeaProjects/first-application/resources/complaints.txt";
    private static final String CALL_LOG_FILE_PATH = "/Users/tv/IdeaProjects/first-application/resources/callLog.txt";

    public static void readComplaintsFromFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            Complaint complaint = ComplaintParser.parseComplaint(line);
            sendComplaintToDispatcher(complaint);
        }
    }
    public static void sendComplaintToDispatcher(Complaint complaint) {
        // Simulate call handling logic here
        String callDateTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        // Now we log the call with the complaint details
        logCallResult(complaint.getId(), callDateTime, complaint.getPhone(), complaint.getComplaintText());
    }


    public static void logCallResult(int id, String callDateTime, String phone, String complaintText) {
        String logEntry = String.format("%d, %s, %s, \"%s\"\n", id, callDateTime, phone, complaintText);
        try {
            Files.write(Paths.get(CALL_LOG_FILE_PATH), logEntry.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.err.println("Error writing to call log file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        logCallResult(1, "2024-03-20 12:34:56", "+375 (29) 898-12-13", "Кто-то оборвал мне телефонный кабель");
        logCallResult(2, "2024-03-21 12:34:59", "+375 (44) 564-13-34", "Почему опять не работает интернет?");
        logCallResult(3, "2024-03-19 11:35:21", "+375 (25) 121-21-12", "Отключен свет");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(MAX_DISPATCHERS);
        executor.scheduleAtFixedRate(() -> {
            try {
                readComplaintsFromFile( COMPLAINTS_FILE_PATH );
            } catch (IOException e) {
                System.out.println("Error reading complaint file: " + e.getMessage());
            }
        }, 0, 2, TimeUnit.MINUTES);
    }
}

