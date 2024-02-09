package com.tatchik.cs.lesson19;

public class Lesson19Runner {
    public static void main(String[] args) {
        int value = 0;
        whileExample(value);
        doWhileExample(value);

    }

    public static void whileExample(int value) {
        while (value > 0) {
            System.out.println(value);
            value -= 3;
        }
    }

    public static void doWhileExample(int value) {
        do {
            System.out.println(value);
            value -= 3;
        } while (value > 0);
    }
}
