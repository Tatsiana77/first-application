package com.tatchik.cs.homework6.arrays.task1;

import java.util.Objects;

public class Chat {
    private String name;
    private int users;

    public Chat(String name, int users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public int getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return users == chat.users && Objects.equals(name, chat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, users);
    }
}
