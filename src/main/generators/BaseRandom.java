package main.generators;

import java.util.Random;

public class BaseRandom {
    
    public static final int ONE_BILLION = 1000000000;
    private Random random;

    public BaseRandom(long seed) {
        random = new Random(seed);
    }

    public void generateRandom() {
        float[] randomNumbers = new float[ONE_BILLION];
        long startTime = System.nanoTime();
        for (int i = 0; i < ONE_BILLION; i++) {
            randomNumbers[i] = random.nextFloat();
        }
        long endTime = System.nanoTime();
        long milliseconds = (endTime - startTime)/1000000;
        System.out.println("Base Random created 1,000,000,000 Random Numbers in " + milliseconds + " milliseconds");
    }

}
