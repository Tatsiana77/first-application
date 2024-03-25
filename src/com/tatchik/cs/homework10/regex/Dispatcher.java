package com.tatchik.cs.homework10.regex;

public class Dispatcher {
    public void processComplaint(Complaint complaint) {
        try {
            System.out.println("Processing complaint from " + complaint.getFullName());
            Thread.sleep(3000 + (long) (Math.random() * 2000));
            System.out.println("Complaint processed.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
