package main.generators;

public class XORRandom {
    public static final long TWO_TO_THE_SIXTY_FOUR = 2^64;
    private int count;

    public XORRandom(int count) {
        this.count = count;
    }
    
    public float[] generateRandom() {
        float[] randomNumbers = new float[count];
        randomNumbers[0] = 282;
        long startTime = System.nanoTime();
        for (int i = 1; i < count; i++) {
            randomNumbers[i] = generateXOR(randomNumbers[i-1]);
        }
        long endTime = System.nanoTime();
        long milliseconds = (endTime - startTime)/1000000;
        System.out.println("XOR created " + count + " Random Numbers in " + milliseconds + " milliseconds");
        return randomNumbers;
    }

    private static float generateXOR(float seed) {
        return generateXOR((long) seed*TWO_TO_THE_SIXTY_FOUR)/TWO_TO_THE_SIXTY_FOUR;
    }

    private static long generateXOR(long seed) {
        seed ^= (seed << 21);
        seed ^= (seed >>> 35);
        seed ^= (seed << 4);
        return seed;
    }

    
}
