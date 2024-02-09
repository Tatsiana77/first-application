package com.tatchik.cs.lesson20;
/**
 * В 1626 году индейцы продали Манхэттен за 24$.
 *    Написать программу, которая высчитывает сумму,
 *    получившуюся бы в текущем году, если бы индейцы положили эти
 *    деньги в банк под 5% годовых.
 */

public class Task3 {
    public static void main(String[] args) {
        int startYear = 1626;
       // int finishYear = 2024;
        double sum = 24;
        double precent = 0.05;
        double result = calculate(startYear, sum, precent);
        System.out.println(result);
    }

    private static double calculate(int startYear, double sum, double precent) {
        double result = sum;
        for (int currentYear = startYear + 1; currentYear <= 2024; currentYear++) {
            result += result * precent;
            System.out.println(currentYear + " : " + result);
        }
        return result;
    }
}
