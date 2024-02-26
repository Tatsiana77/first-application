package com.tatchik.cs.homework6.arrays.task1;

import com.tatchik.cs.homework6.arrays.task1.Chat;
import com.tatchik.cs.homework6.arrays.task1.ChatOperations;

import java.util.ArrayList;
import java.util.List;

public class ChatRunning {
    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Chat1", 1200));
        chats.add(new Chat("Chat2", 800));
        chats.add(new Chat("Chat3", 1500));

        ChatOperations chatOperations = new ChatOperations(chats);

        // Удаление чатов с менее чем 1000 пользователями
        chatOperations.removeChatsWithFewUsers();

        // Сортировка чатов по убыванию пользователей и названию
        chatOperations.sortChatsByUsersAndName();

        // Вывод отсортированных чатов
        chatOperations.displayChats();
    }
}
