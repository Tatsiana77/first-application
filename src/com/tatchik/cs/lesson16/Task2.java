package com.tatchik.cs.lesson16;

public class Task2 {
    public static void main(String[] args) {
        int value = -12343;
        int remainder = value % 10;
        boolean test = remainder == 3 || remainder == -3;
        if(test){
            System.out.println("Yes");
        } else {
            System.out.println("No remainder = "  + remainder);
        }
    }
}
