package com.tatchik.cs.homework5.inheritancePolymorphism;

public final class SpaceUtils {
    private SpaceUtils() {
        // Приватный конструктор, чтобы нельзя было создать объект этого класса
    }

    // Статический метод для определения силы гравитации
    public static double calculateGravityForce(CosmicObject obj1, CosmicObject obj2, double distance) {
        // Здесь может быть любая формула на основании расстояния, масс и других параметров
        // Например, простая формула: F = G * (m1 * m2) / (r^2)
        double G = 6.67e-11; // Гравитационная постоянная
        return G * (obj1.getMass() * obj2.getMass()) / (distance * distance);
    }

    // Статический метод для определения, является ли космический объект звездой
    public static boolean isStar(CosmicObject cosmicObject) {
        // Здесь можно использовать какие-то условия для определения, является ли объект звездой
        // Например, предположим, что все объекты с массой больше 1e30 кг считаются звездами
        return cosmicObject.getMass() > 1e30;
    }
}
