package com.tatchik.cs.homework;


/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes
 * и выводит на консоль  в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */
public class Task1HomeWork {
    public static void main(String[] args) {
        testQuarterFunction(25);
        testQuarterFunction(32);
        testQuarterFunction(47);
        testQuarterFunction(5);
        testQuarterFunction(62);
    }

    public static int getQuarter(int minutes) {
        if (0 <= minutes && minutes <= 59) {
            return  (minutes / 15) % 4 + 1;
        } else {
            System.out.println(" incorrect value of minutes");
        }
      return  -1;
    }

    public static void testQuarterFunction(int minutes) {
        System.out.println("Test with minutes : " + minutes);
        int quarter = getQuarter(minutes);
        if (quarter != -1) {
            System.out.println("Time  " + minutes + " minutes income to " + quarter + " a quarter of an hour");
        }
        System.out.println();
    }
}
