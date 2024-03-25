package com.tatchik.cs.homework10.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplaintParser {
    public static Complaint parseComplaint(String line) {
        Pattern pattern = Pattern.compile("^(\\d+), (\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}), (.*), (\\+\\d{3} \\d{2} \\d{3} \\d{2} \\d{2}), (.*)$");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {

            int id = Integer.parseInt(matcher.group(1));
            String dateTime = matcher.group(2);
            String fullName = matcher.group(3);
            String phone = matcher.group(4);
            String complaintText = matcher.group(5);

            phone = formatPhone(phone);

            return new Complaint(id, dateTime, fullName, phone, complaintText);
        } else {
            throw new IllegalArgumentException("Invalid line format: " + line);
        }
    }

    private static String formatPhone(String phone) {
        phone = phone.replaceAll("\\D+", "");
        Pattern pattern = Pattern.compile("^(\\d{3})(\\d{2})(\\d{3})(\\d{2})(\\d{2})$");
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            return String.format("+%s (%s) %s-%s-%s", matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5));
        } else {
            return phone;
        }
    }
}
