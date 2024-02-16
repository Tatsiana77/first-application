package com.tatchik.cs.homework4.taskOOP.home;

import java.util.Arrays;
import java.util.Objects;

public class Flat {
    private Room[] rooms;
    private  int numberFlat;

    public Flat(Room[] rooms, int numberFlat) {
        this.rooms = rooms;
        this.numberFlat = numberFlat;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public int getNumberFlat() {
        return numberFlat;
    }

    public void setNumberFlat(int numberFlat) {
        this.numberFlat = numberFlat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat flat = (Flat) o;
        return numberFlat == flat.numberFlat && Arrays.equals(rooms, flat.rooms);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberFlat);
        result = 31 * result + Arrays.hashCode(rooms);
        return result;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "rooms=" + Arrays.toString(rooms) +
                ", numberFlat=" + numberFlat +
                '}';
    }

    public void print() {
        System.out.println("Квартира номер:  " + numberFlat);
        for (Room room : rooms) {
            room.print();
        }
    }
}
