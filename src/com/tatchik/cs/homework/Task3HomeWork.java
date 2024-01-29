package com.tatchik.cs.homework;

public class Task3HomeWork {
    public static void main(String[] args) {
        int a1 = 6, b1 = 10; // Sides of the first triangle
        int a2 = 6, b2 = 10; // Sides of the second triangle

        double area1 = calculateTriangleArea(a1, b1); // Calculating the area of the first triangle
        double area2 = calculateTriangleArea(a2, b2); //  Calculating the area of the second  triangle

        compareAreas(area1, area2); // Comparing the areas and printing the result
    }

    // Function to calculate the area of a right-angled triangle based on its sides
    public static double calculateTriangleArea(int side1, int side2) {
        return 0.5 * side1 * side2;
    }

    // Function to compare the areas of two triangles and print the result using the ternary operator
    public static void compareAreas(double area1, double area2) {
        String result = (area1 > area2) ? "Triangle 1 is larger than Triangle 2" :
                (area1 < area2) ? "Triangle 1 is smaller than Triangle 2" :
                        "Areas of the triangles are equal";
        System.out.println(result);
    }
}
