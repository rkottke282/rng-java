package main.generators;

import java.util.Random;
import java.util.concurrent.locks.*;

// Code from https://www.javamex.com/tutorials/random_numbers/numerical_recipes.shtml
public class NumericalRecipe extends Random {

    private static final long TWO_TO_THE_ONE_NINETY_TWO = 2^192; 
    public static final int ONE_BILLION = 1000000000;
    private Lock l = new ReentrantLock();
    private long u;
    private long v = 4101842887655102017L;
    private long w = 1;

    public NumericalRecipe(long seed) {
        l.lock();
        u = seed ^ v;
        nextLong();
        v = u;
        nextLong();
        w = v;
        nextLong();
        l.unlock();
    }
    
    public void generateRandom() {
        float[] randomNumbers = new float[ONE_BILLION];
        long startTime = System.nanoTime();
        for (int i = 0; i < ONE_BILLION; i++) {
            randomNumbers[i] = next(0);
        }
        long endTime = System.nanoTime();
        long milliseconds = (endTime - startTime)/1000000;
        System.out.println("XOR created 1,000,000,000 Random Numbers in " + milliseconds + " milliseconds");
    }
  
    protected float next(float bits) {
        return next((int) bits*TWO_TO_THE_ONE_NINETY_TWO)/TWO_TO_THE_ONE_NINETY_TWO;
    }
    
    protected int next(int bits) {
        return (int) (nextLong() >>> (64-bits));
    }

    public long nextLong() {
        l.lock();
        try {
            u = u * 2862933555777941757L + 7046029254386353087L;
            v ^= v >>> 17;
            v ^= v << 31;
            v ^= v >>> 8;
            w = 4294957665L * (w & 0xffffffff) + (w >>> 32);
            long x = u ^ (u << 21);
            x ^= x >>> 35;
            x ^= x << 4;
            long ret = (x + v) ^ w;
            return ret;
        } finally {
            l.unlock();
        }
    }
}
