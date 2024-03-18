package com.tatchik.cs.homework9.threads;

public class CrystalRace {
    public static void main(String[] args) {
        Mage fireMage = new FireMage();
        Mage airMage = new AirMage();

        fireMage.start(); // Запуск соревнования для мага огня
        airMage.start(); // Запуск соревнования для мага воздуха
    }
}
