package com.tatchik.cs.homework4.taskOOP.home;

import java.util.Arrays;
import java.util.Objects;

public class House {
    private Floor[] floors ;
    private  int numberHouse;

    public House(Floor[] floors, int numberHouse) {
        this.floors = floors;
        this.numberHouse = numberHouse;
    }

    public Floor[] getFloors() {
        return floors;
    }

    public void setFloors(Floor[] floors) {
        this.floors = floors;
    }

    public void printState(){
        System.out.println(" Number of house : " + numberHouse + ", " + "Number of floors  : "  + floors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return numberHouse == house.numberHouse && Arrays.equals(floors, house.floors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberHouse);
        result = 31 * result + Arrays.hashCode(floors);
        return result;
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + Arrays.toString(floors) +
                ", numberHouse=" + numberHouse +
                '}';
    }
    public void print() {
        System.out.println("Дом номер " + numberHouse);
        for (Floor floor : floors) {
            floor.print();
        }
    }

}
