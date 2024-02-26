package com.tatchik.cs.homework5.inheritancePolymorphism;

/**
 * Создать иерархию классов, описывающих объекты в космосе.
 * Например, планета, спутник, звезда, астероид и т.д. У каждого есть набор методов и характеристик-свойств, как общих (масса), так и присущих только этому типу космического объекта.
 * Необходимо учесть следующее:
 * В иерархии должно быть минимум 10 классов/интерфейсов
 * Обязательно использовать наследование (достаточно 1-2 уровней)
 * Использовать полиморфизм и продемонстрировать переопределение методов в иерархии
 * Продемонстрировать добавление собственных методов в классах-наследниках (можно с помощью интерфейсов)
 * При разработке иерархии держать в уме принцип инкапсуляции, выбирать корректные имена классов, их полей и методов, пользоваться преимуществами полиморфизма
 * Отдавайте предпочтение интерфейсам, а не абстрактным классам
 * При переопределении методов обязательно использовать аннотацию @Override
 * Не создавать лишних классов в системе (полностью дублирующих или не содержащих назначения)
 * Каждый класс должен выполнять своё назначение
 * Для каждого не абстрактного класса переопределить метод toString() класса для представления информации о классах в строковой форме
 * Создать общие методы:
 * - Рассчитывающие диаметр космического объекта
 * - Сравнивающий массы 2 космических объектов (метод не статический!)
 * Создать утилитный класс* SpaceUtils со следующими статическими методами:
 * - Принимающий 2 космический объекта и определяющий силу гравитации между ними (можно придумать любую формула на основании расстоянии между объектами и т.д.)
 * - Принимающий космический объект и определяющий, является ли он звездой или нет
 * Создать класс SpaceRunner, где протестировать написанный функционал
 * В этом задании нет одного правильного решения, подойдите к нему творчески.
 * Утилитный класс* - это такой класс, который:
 * - помечен ключевым словом final, чтобы запретить наследоваться от него
 * - имеет private конструктор, чтобы нельзя было создать объект этого класса имеет только статические методы и константы
 */

public class SpaceRunner {
    public static void main(String[] args) {
        Planet earth = new Planet(5.97e24, 6371e3);
        Moon moon = new Moon(7.35e22, "Moon");
        Sun sun = new Sun(1.989e30, "G-type");
        Vesta vesta = new Vesta(2.59076e20, "V-type");

        System.out.println("Earth: " + earth);
        System.out.println("Moon: " + moon);
        System.out.println("Sun: " + sun);
        System.out.println("Vesta: " + vesta);

        // Вызов общего метода для сравнения масс
        earth.compareMass(moon);

        // Вызов уникального метода только для планеты
        ((Rotatable) earth).rotate();

        // Вызов уникального метода только для спутника
        ((Satellite) moon).orbit();

        // Пример использования утилитного класса
        double distanceEarthMoon = 384400e3; // Расстояние между Землей и Луной
        double gravityForceEarthMoon = SpaceUtils.calculateGravityForce(earth, moon, distanceEarthMoon);
        System.out.println("Gravity Force between Earth and Moon: " + gravityForceEarthMoon);

        // Пример использования второго метода утилитного класса
        System.out.println("Is Earth a star? " + SpaceUtils.isStar(earth));
        System.out.println("Is Sun a star? " + SpaceUtils.isStar(sun));

    }
}
