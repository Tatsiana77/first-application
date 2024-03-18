package com.tatchik.cs.homework9.threads;

public class CrystalRace {
    public static void main(String[] args) {
        System.out.println("The crystal race has started!");
        Mage fireMage = new Mage("Fire");
        Mage airMage = new Mage("Air");

        fireMage.start();
        airMage.start();
    }
}
