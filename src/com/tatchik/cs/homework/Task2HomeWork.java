package com.tatchik.cs.homework;

/**
 * Даны 3 переменные:
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 **/

public class Task2HomeWork {
    public static void main(String[] args) {
        testCalculateFunction(24.4, 10.1, '+');
        testCalculateFunction(24.4, 10.1, '-');
        testCalculateFunction(24.4, 10.1, '*');
        testCalculateFunction(24.4, 10.1, '/');
        testCalculateFunction(24.4, 10.1, '%');
    }

    public static double calculate(double operand1, double operand2, char operation) {
        return switch (operation) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> (operand2 != 0) ? operand1 / operand2 : DivisionByZero();
            case '%' -> (operand2 != 0) ? operand1 % operand2 : ModuloByZero();
            default -> {
                System.out.println("Error: Invalid operation");
                yield Double.NaN;
            }
        };
    }

    private static double DivisionByZero() {
        System.out.println("Error: Division by zero");
        return Double.NaN;
    }

    private static double ModuloByZero() {
        System.out.println("Error: Modulo by zero");
        return Double.NaN;
    }

    public static void testCalculateFunction(double operand1, double operand2, char operation) {
        System.out.println("Test with operands: " + operand1 + ", " + operand2 + " and operation: " + operation);
        double result = calculate(operand1, operand2, operation);
        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        }
        System.out.println();

    }
}
