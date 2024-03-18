package com.tatchik.cs.homework9.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mage extends Thread {
    private List<Crystal> collectedCrystals = Collections.synchronizedList(new ArrayList<>());
    private static final int GOAL = 500;

    @Override
    public void run() {
        while (!hasCollectedRequiredCrystals()) {
            synchronized (Planet.class) { // Синхронизация на уровне класса Planet
                collectedCrystals.addAll(Planet.generateCrystals());
            }
            if (hasCollectedRequiredCrystals()) {
                System.out.println(this.getClass().getSimpleName() + " has won!");
                System.exit(0);
            }
            try {
                Thread.sleep(1000); // Имитация задержки в "сутки"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean hasCollectedRequiredCrystals() {
        long redCount = collectedCrystals.stream().filter(c -> c.getType() == Crystal.Type.RED).count();
        long whiteCount = collectedCrystals.stream().filter(c -> c.getType() == Crystal.Type.WHITE).count();
        return redCount >= GOAL && whiteCount >= GOAL;
    }
}

