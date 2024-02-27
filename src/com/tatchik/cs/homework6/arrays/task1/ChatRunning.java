package com.tatchik.cs.homework6.arrays.task1;

import com.tatchik.cs.homework6.arrays.task1.Chat;
import com.tatchik.cs.homework6.arrays.task1.ChatOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */

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
