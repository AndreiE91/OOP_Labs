
/**
 * Write a description of class Hammurabi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// Author : Fred Swartz
// TODO   : * Prompt for amount to feed peasants.
//          * Check that there is enough grain to meet requests.
//          * Print the number of peasants with the status info.
//          * Stop the simulation if the population drops to 0.

import javax.swing.*;

public class Hammurabi {

    //============================================================= main
    public static void main(String[] args) {

        //... Initialization
        Kingdom samaria = new Kingdom();  // Create a new Kingdom
        int year = 1;


        //... Run the simulation for 10 years or until everyone starves.
        while (year <= 10) {
            displayStatus(samaria, year);

            //TODO: Ask the Exalted Ruler how much to feed the people.
            int food = 0;  // This is in place of asking for input.

            String plantStr = JOptionPane.showInputDialog(null,
                    "Exalted Ruler, how much of the remaining "
                    + (samaria.getGrain()-food) + " bushels should be planted?");
            int seeds = Integer.parseInt(plantStr);

            //... TODO: Check if not enough grain for this request, Reprompt.

            //... Update the food and population of this kingdom.
            samaria.simulateOneYear(food, seeds);
            year++;
        }

        //... Show final state.
        displayStatus(samaria, year);

    }


    //==================================================== displayStatus
    // Shows the amount of grain and population for
    // and Kingdom.  TODO: Add peasant output.
    private static void displayStatus(Kingdom country, int yr) {
        JOptionPane.showMessageDialog(null,
                "Exalted Ruler, your riches at year " + yr + ":"
                + "\n   Grain = " + country.getGrain());
    }
}
