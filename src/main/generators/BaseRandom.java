package main.generators;

import java.util.Random;

public class BaseRandom {
    
    private int count;
    private Random random;

    public BaseRandom(long seed, int count) {
        random = new Random(seed);
        this.count = count;
    }

    public float[] generateRandom() {
        float[] randomNumbers = new float[count];
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            randomNumbers[i] = random.nextFloat();
        }
        long endTime = System.nanoTime();
        long milliseconds = (endTime - startTime)/1000000;
        System.out.println("Base Random created " + count + " Random Numbers in " + milliseconds + " milliseconds");
        return randomNumbers;
    }

}
