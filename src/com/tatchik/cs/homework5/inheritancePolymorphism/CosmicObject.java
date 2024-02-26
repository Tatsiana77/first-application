package com.tatchik.cs.homework5.inheritancePolymorphism;

public interface CosmicObject {
    double getMass(); // Масса космического объекта
    double calculateDiameter(); // Рассчет диаметра
    void compareMass(CosmicObject otherObject); // Общий метод для сравнения масс
}
