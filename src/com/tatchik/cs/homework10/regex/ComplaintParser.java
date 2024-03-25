package com.tatchik.cs.homework10.regex;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplaintParser {
    private static final Pattern pattern = Pattern.compile("^(\\d+),\\s*(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}),\\s*([^,]+?),\\s*([^,]+?),\\s*(.+)$");

    public static Complaint parseComplaint(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            int id = Integer.parseInt(matcher.group(1));
            LocalDateTime dateTime = LocalDateTime.parse(matcher.group(2), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String fullName = matcher.group(3);
            String phone = matcher.group(4);
            String complaintText = matcher.group(5);
            return new Complaint(id, dateTime, fullName, phone, complaintText);
        } else {
            System.err.println("Invalid line format: " + line);
            return null;
        }
    }
}
