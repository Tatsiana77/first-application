package com.tatchik.cs.homework6.arrays.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей”
 * будет список объектов типа Пользователь, который имеет 3 поля:
 * id (целочисленный идентификатор),
 * имя и возраст.
 * Задача:
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */


public class ChatAndUserRunning {
    public static void main(String[] args) {
        User user1 = new User(1, "User1", 25);
        User user2 = new User(2, "User2", 30);
        User user3 = new User(3, "User3", 22);

        List<User> users1 = Arrays.asList(user1, user2);
        List<User> users2 = Collections.singletonList(user3);

        Chat chat1 = new Chat("Chat1", users1);
        Chat chat2 = new Chat("Chat2", users2);

        List<Chat> chatList = Arrays.asList(chat1, chat2);

        ChatManager chatManager = new ChatManager(new ArrayList<>(chatList));

        // Получение списка пользователей старше 18 лет
        List<User> allUsersAbove18 = chatManager.getAllUsersAbove18();
        System.out.println("Пользователи старше 18 лет: " + allUsersAbove18);

        // Подсчет среднего возраста
        double averageAge = chatManager.calculateAverageAge();
        System.out.println("Средний возраст пользователей: " + averageAge);
    }
}
