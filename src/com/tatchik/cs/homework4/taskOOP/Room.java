package com.tatchik.cs.homework4.taskOOP;

import java.util.Objects;

public class Room {
    private  boolean isPassage;

    public Room(boolean isPassage) {
        this.isPassage = isPassage;
    }

    public boolean isPassage() {
        return isPassage;

    }

    public void setWhole(boolean isPassage) {
        this.isPassage = isPassage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return isPassage == room.isPassage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isPassage);
    }

    @Override
    public String toString() {
        return "Room{" +
                "whole=" + isPassage +
                '}';
    }
    public void print() {
        System.out.println("Комната: проходная - :  " + isPassage);
    }
}
