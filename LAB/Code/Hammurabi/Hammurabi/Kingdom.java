
/**
 * Write a description of class KingDom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// Author : Fred Swartz
// TODO   : * Add population instance variable.  Default value 100.
//          * Add a getter method for population.
//          * Compute the new population based on food.

class Kingdom {
    //========================================================== constants
    public static int MIN_GRAIN_TO_SURVIVE = 20;
    public static int MAX_LAND_FARMABLE_PER_PERSON = 15;
    public static int SEED_REQUIRED_PER_ACRE = 2;

    //================================================= instance variables
    private int myGrain = 3000;
    private int myArea  = 1000;

    //=========================================================== getGrain
    public int getGrain() {
        return myGrain;
    }

    //============================================================ getArea
    public int getArea() {
        return myArea;
    }

    //==================================================== simulateOneYear
    public void simulateOneYear(int food, int seed) {

        //TODO: Need to calculate new population.based on food.

        //... Reduce grain stockpile by amount used for food and seed
        myGrain = myGrain - food - seed;

        //... Calculate new harvest
        //    1. How many acres can be planted with seed.
        //    2. The yield per acre is random (2-6)
        //    3. Harvest is yield * area planted.
        int acresPlanted = seed / SEED_REQUIRED_PER_ACRE;
        int yieldPerAcre = 2 + (int)(5 * Math.random());
        int harvest      = yieldPerAcre * acresPlanted;

        //... Compute new amount of grain in storage.
        myGrain += harvest;  // New amount of grain in storage.
    }
}
