package com.tatchik.cs.homework9.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Planet {
    private static final Random random = new Random();

    public static List<Crystal> generateCrystals() {
        List<Crystal> crystals = new ArrayList<>();
        int crystalCount = 2 + random.nextInt(4); // Генерация от 2 до 5 кристаллов

        for (int i = 0; i < crystalCount; i++) {
            Crystal.Type type = random.nextBoolean() ? Crystal.Type.RED : Crystal.Type.WHITE;
            crystals.add(new Crystal(type));
        }

        return crystals;
    }
}
