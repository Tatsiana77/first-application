package com.tatchik.cs.homework4.taskOOP;

import java.util.Arrays;
import java.util.Objects;

public class Floor {
    private Flat[] flats;
    private int numberFloor;


    public Floor(Flat[] flats, int numberFloor) {
        this.flats = flats;
        this.numberFloor = numberFloor;
    }

    public Flat[] getFlats() {
        return flats;
    }

    public void setFlats(Flat[] flats) {
        this.flats = flats;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return numberFloor == floor.numberFloor && Arrays.equals(flats, floor.flats);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberFloor);
        result = 31 * result + Arrays.hashCode(flats);
        return result;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "flats=" + Arrays.toString(flats) +
                ", numberFloor=" + numberFloor +
                '}';
    }

    public void print() {
        System.out.println("Этаж : " + numberFloor + ", количество квартир   " + flats.length);
        for (Flat flat : flats) {
            flat.print();
        }
    }
}
