package main;

import main.generators.*;

class RandomNumberGenerator {

    private static final long seed = 282;
    
    public static void main(String[] args) {
        BaseRandom baseRandom = new BaseRandom(seed);
        baseRandom.generateRandom();

        XORRandom xorRandom = new XORRandom();
        xorRandom.generateRandom();

        NumericalRecipe numericalRecipe = new NumericalRecipe(seed);
        numericalRecipe.generateRandom();
    }
}
