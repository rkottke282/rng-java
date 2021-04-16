package main.generators;

public class XORRandom {
    public static final long TWO_TO_THE_SIXTY_FOUR = 2^64;
    public static final int ONE_BILLION = 1000000000;

    public XORRandom() {

    }
    
    public void generateRandom() {
        float[] randomNumbers = new float[ONE_BILLION];
        randomNumbers[0] = 282;
        long startTime = System.nanoTime();
        for (int i = 1; i < ONE_BILLION; i++) {
            randomNumbers[i] = generateXOR(randomNumbers[i-1]);
        }
        long endTime = System.nanoTime();
        long milliseconds = (endTime - startTime)/1000000;
        System.out.println("XOR created 1,000,000,000 Random Numbers in " + milliseconds + " milliseconds");
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
