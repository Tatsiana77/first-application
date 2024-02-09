package com.tatchik.cs.lesson16;

public class Task4 {

    public static void main(String[] args) {
        int year = 2000;
//        boolean result = isLeapYear(year);
//        System.out.println(result);
        System.out.println(" Високосный : " + isLeapYear(year));
    }

        public static boolean isLeapYear(int year){
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }
    }

