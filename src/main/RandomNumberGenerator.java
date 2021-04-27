package main;

import main.generators.*;

class RandomNumberGenerator {

    private static final long seed = 282;
    private static final int ONE_HUNDRED_MILLION = 100;
    
    public static void main(String[] args) {
        FileCreator fileCreator1 = new FileCreator("baserandom");
        BaseRandom baseRandom = new BaseRandom(seed, ONE_HUNDRED_MILLION);
        fileCreator1.createFile(baseRandom.generateRandom());

        // FileCreator fileCreator2 = new FileCreator("xorrandom");
        // XORRandom xorRandom = new XORRandom(ONE_HUNDRED_MILLION);
        // fileCreator2.createFile(xorRandom.generateRandom());

        // FileCreator fileCreator3 = new FileCreator("numericalreciperandom");
        // NumericalRecipe numericalRecipe = new NumericalRecipe(seed, ONE_HUNDRED_MILLION);
        // fileCreator3.createFile(numericalRecipe.generateRandom());
    }
}
