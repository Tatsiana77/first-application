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
        // Определение порога минимального количества пользователей в чате
        final int MIN_USERS_THRESHOLD = 1000;
        Iterator<Chat> iterator = chatList.iterator();
        while (iterator.hasNext()) {
            Chat chat = iterator.next();
            if (chat.getUsers() < MIN_USERS_THRESHOLD) {
                iterator.remove();
            }
        }
    }

    // Метод для сортировки чатов по убыванию пользователей, затем по названию
    public void sortChatsByUsersAndName() {
        Collections.sort(chatList, new Comparator<Chat>() {
            @Override
            public int compare(Chat chat1, Chat chat2) {
                int usersComparison = Integer.compare(chat2.getUsers(), chat1.getUsers());
                if (usersComparison != 0) {
                    return usersComparison;
                }
                return chat1.getName().compareTo(chat2.getName());
            }
        });
    }

    // Метод для сортировки чатов по названию по умолчанию
    public void sortChatsByName() {
        Collections.sort(chatList, new Comparator<Chat>() {
            @Override
            public int compare(Chat chat1, Chat chat2) {
                return chat1.getName().compareTo(chat2.getName());
            }
        });
    }

    // Метод для вывода чатов
    public void displayChats() {
        for (Chat chat : chatList) {
            System.out.println(chat);
        }
    }
}
