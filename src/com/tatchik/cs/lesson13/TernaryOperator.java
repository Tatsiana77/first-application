package com.tatchik.cs.lesson13;

public class TernaryOperator {

    public static void main(String[] args) {
        int value1 = 23;
        int value2 = 100;
        int max = value1> value2 ? value1: value2;
        int min = value1 < value2 ? value1 : value2;
        System.out.println(" value max is "  + max );
        System.out.println(" value min  is "  + min);
    }
}
