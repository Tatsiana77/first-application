package com.tatchik.cs.homework4.taskOOP;


/**
 * Представить в виде классов и их композиции следующую модель.
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * В каждом классе реализовать метод print, который на консоль выводит информацию об объекте
 * (должны присутствовать все поля объекта!).
 * Например, метод print класса этаж должен выводить на консоль:
 * “Этаж 2, количество квартир 18”
 * Создание всех объектов вынести в отдельный класс с методом main.
 * Там же реализовать метод printAllInformation, который на вход принимает
 * объект типа дом, и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
 */
public class Task1OOP {
    public static void main(String[] args) {

         // Создание комнат
        Room room1 = new Room(false);
        Room room2 = new Room(true);

        // Создание квартиры с комнатами
        Flat[] flats = new Flat[18];
        for (int i = 0; i < flats.length; i++) {
            flats[i] = new Flat(new Room[]{room1, room2}, i + 1);
        }

        // Создание этажа с квартирами
        Floor[] floorsInHouse1 = new Floor[9];
        for (int i = 0; i < floorsInHouse1.length; i++) {
            floorsInHouse1[i] = new Floor(flats, 2);
        }

        // Создание дома с этажами
        House house1 = new House(floorsInHouse1, 9);

        // Вывод информации о доме, этажах, квартирах и комнатах
        printAllInformation(house1);
    }

    // Метод для вывода всей информации о доме
    public static void printAllInformation(House house) {
        house.print();
    }
}
