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

public class Task2HomeWorkNew {
    private final static char ADDITION = '+';
    private final static char SUBTRACTION = '-';
    private final static char MULTIPLICATION = '*';
    private final static char DIVISION = '/';
    private final static char MODULUS = '%';

    public static void main(String[] args) {
        double operand1 = 24.4;
        double operand2 = 10.1;

        double result = calculate(operand1, operand2, ADDITION);
        System.out.println("Result: " + result);

    }

    private static double calculate(double operand1, double operand2, char operation) {
        double result = 0.0;
        if (operation == ADDITION) {
            result = addition(operand1, operand2);
        } else if (operation == SUBTRACTION) {
            result = subtraction(operand1, operand2);
        } else if (operation == MULTIPLICATION) {
            result = multiplication(operand1, operand2);
        } else if (operation == DIVISION) {
            if (operand2 != 0) {
                result = division(operand1, operand2);
            } else {
                throw new ArithmeticException("Division by zero");
            }
        } else if (operation == MODULUS) {
            if (operand2 != 0) {
                result = modulus(operand1, operand2);
            } else {
                throw new ArithmeticException("Modulus by zero");
            }
        } else {
            throw new IllegalArgumentException("Invalid operation: " + operation);
        }

        return result;
    }

    private static double addition(double operand1, double operand2) {
        return operand1 + operand2;
    }

    private static double subtraction(double operand1, double operand2) {
        return operand1 - operand2;
    }

    private static double multiplication(double operand1, double operand2) {
        return operand1 * operand2;
    }

    private static double division(double operand1, double operand2) {
        if (operand2 != 0) {
            return operand1 / operand2;
        } else {
            throw new ArithmeticException("Division by zero");
        }
    }

    private static double modulus(double operand1, double operand2) {
        if (operand2 != 0) {
            return operand1 % operand2;
        } else {
            throw new ArithmeticException("Modulus by zero");
        }
    }
}
