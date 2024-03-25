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

            // Вывод текущего состояния сбора кристаллов магом.
            printCollectedCrystalsCount();
            // Проверяем, собрал ли маг необходимое количество кристаллов для победы и не завершена ли гонка.
            if (hasCollectedRequiredCrystals() && !raceFinished) {
                // Используем синхронизированный блок на уровне класса Mage, чтобы гарантировать,
                // что в данный момент времени только один поток может проверить и изменить состояние гонки.
                synchronized (Mage.class) {
                    // Повторно проверяем, не завершена ли гонка, чтобы избежать ситуации, когда два мага
                    // одновременно достигают условий победы и пытаются объявить себя победителями.
                    if (!raceFinished) {
                        // Выводим в консоль сообщение о победе мага данной расы.
                        System.out.println("\033[31m"  +  race + " \033[0m"
                                + " mage has collected the required crystals and  " + "\033[31m"  + " WON " +  " \033[0m"
                                + "the race!");
                        // Устанавливаем флаг raceFinished в true, чтобы указать на завершение гонки
                        // и предотвратить дальнейшие объявления победителя.
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
//        long redCount = collectedCrystals.stream().filter(c -> c.getType() == Crystal.Type.RED).count();
//        long whiteCount = collectedCrystals.stream().filter(c -> c.getType() == Crystal.Type.WHITE).count();
//        return redCount >= GOAL && whiteCount >= GOAL;

        long redCount = 0;
        long whiteCount = 0;
       for (Crystal crystal : collectedCrystals) {
          if (crystal.getType() == Crystal.Type.RED) {
               redCount++;
           }
         else if (crystal.getType() == Crystal.Type.WHITE) {
                whiteCount++;
            }
       }
      return redCount >= GOAL && whiteCount >= GOAL;
    }

    private void printCollectedCrystalsCount() {
        long redCount = 0;
        long whiteCount = 0;

        for (Crystal crystal : collectedCrystals) {
            if (crystal.getType() == Crystal.Type.RED) {
                redCount++;
            } else if (crystal.getType() == Crystal.Type.WHITE) {
                whiteCount++;
            }
        }

        System.out.println(race + " mage has collected " + redCount + " red crystals and " + whiteCount + " white crystals.");
    }
}

