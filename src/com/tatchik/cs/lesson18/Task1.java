package com.tatchik.cs.lesson18;

public class Task1 {
    public static void main(String[] args) {
        int value = 100;
        int value2 = 38;

        int result2 = Math.max(value, value2);
        System.out.println("result 2  = "+ result2);

        int result = getMax(value, value2);
        System.out.println("result  = " + result);

    }

    public static int getMax(int first, int second) {
        return first > second ? first : second;
    }
}
