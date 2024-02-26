package com.tatchik.cs.homework6.arrays.task1;

import com.tatchik.cs.homework6.arrays.task2.User;

import java.util.*;
import java.util.stream.Collectors;

public class ChatOperations {
    private List<Chat> chatList;

    public ChatOperations(List<Chat> chatList) {
        this.chatList = chatList;
    }

    // Метод для удаления чатов с менее чем 1000 пользователями
    public void removeChatsWithFewUsers() {
        Iterator<Chat> iterator = chatList.iterator();
        while (iterator.hasNext()) {
            Chat chat = iterator.next();
            if (chat.getUsers() < 1000) {
                iterator.remove();
            }
        }
    }

    // Метод для сортировки чатов по убыванию пользователей, затем по названию
    public void sortChatsByUsersAndName() {
        Collections.sort(chatList, (chat1, chat2) -> {
            // Сортировка по убыванию пользователей
            int usersComparison = Integer.compare(chat2.getUsers(), chat1.getUsers());
            if (usersComparison != 0) {
                return usersComparison;
            }
            // Если количество пользователей одинаково, сортировка по названию
            return chat1.getName().compareTo(chat2.getName());
        });
    }

    // Метод для сортировки чатов по названию по умолчанию
    public void sortChatsByName() {
        Collections.sort(chatList, Comparator.comparing(Chat::getName));
    }

    // Метод для вывода чатов
    public void displayChats() {
        for (Chat chat : chatList) {
            System.out.println(chat);
        }
    }
}
