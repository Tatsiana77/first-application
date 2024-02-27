package com.tatchik.cs.homework6.arrays.task2;

import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private List<Chat> chatList;

    public ChatManager(List<Chat> chatList) {
        this.chatList = chatList;
    }

    // Метод для преобразования списка чатов в список пользователей старше 18 лет
    public List<User> getAllUsersAbove18() {
        // Определение возрастного порога для отбора пользователей
        final int AGE_THRESHOLD = 18;
        List<User> allUsersAbove18 = new ArrayList<>();
        for (Chat chat : chatList) {
            for (User user : chat.getUsers()) {
                if (user.getAge() > AGE_THRESHOLD) {
                    allUsersAbove18.add(user);
                }
            }
        }
        return allUsersAbove18;
    }

    // Метод для подсчета среднего возраста всех пользователей
    public int calculateAverageAge() {
        int totalAge = 0;
        int totalUsers = 0;
        for (Chat chat : chatList) {
            for (User user : chat.getUsers()) {
                totalAge += user.getAge();
                totalUsers++;
            }
        }
        return totalUsers > 0 ? totalAge / totalUsers : 0;
    }
}
