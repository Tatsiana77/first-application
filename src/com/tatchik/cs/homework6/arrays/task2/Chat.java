package com.tatchik.cs.homework6.arrays.task2;

import java.util.List;
import java.util.Objects;

public class Chat {
    private String name;
    private List<User> users;

    public Chat(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(name, chat.name) && Objects.equals(users, chat.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, users);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
