package com.tatchik.cs.homework10.regex;

import java.util.Objects;

public class Complaint {
    private final int id;
    private final String dateTime;
    private final String fullName;
    private final String phone;
    private final String complaintText;

    public Complaint(int id, String dateTime, String fullName, String phone, String complaintText) {
        this.id = id;
        this.dateTime = dateTime;
        this.fullName = fullName;
        this.phone = phone;
        this.complaintText = complaintText;
    }

    public int getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getComplaintText() {
        return complaintText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return id == complaint.id && Objects.equals(dateTime, complaint.dateTime) && Objects.equals(fullName, complaint.fullName) && Objects.equals(phone, complaint.phone) && Objects.equals(complaintText, complaint.complaintText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, fullName, phone, complaintText);
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "id=" + id +
                ", dateTime='" + dateTime + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", complaintText='" + complaintText + '\'' +
                '}';
    }
}
