package com.tatchik.cs.homework9.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mage extends Thread {
    private List<Crystal> collectedCrystals = Collections.synchronizedList(new ArrayList<>());
    private final String race;
    private static final int GOAL = 20;
    private static volatile boolean raceFinished = false;

    public Mage(String race) {
        this.race = race;
    }

    @Override
    public void run() {
        System.out.println(race + " mage starts collecting crystals.");

        while (!raceFinished) {
            List<Crystal> newCrystals = Planet.generateCrystals();
            collectedCrystals.addAll(newCrystals);

            if (hasCollectedRequiredCrystals() && !raceFinished) {
                synchronized (Mage.class) {
                    if (!raceFinished) {
                        System.out.println(race + " mage has collected the required crystals and won the race!");
                        raceFinished = true;
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    private boolean hasCollectedRequiredCrystals() {
        long redCount = collectedCrystals.stream().filter(c -> c.getType() == Crystal.Type.RED).count();
        long whiteCount = collectedCrystals.stream().filter(c -> c.getType() == Crystal.Type.WHITE).count();
        return redCount >= GOAL && whiteCount >= GOAL;
    }
}

