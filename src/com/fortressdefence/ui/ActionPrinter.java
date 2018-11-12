package com.fortressdefence.ui;

/**
 * Class for printing any action from GameMain to the screen. Prints information related to tank damage and
 * fortress health.
 *
 * @author Brandon Verigin
 * @author Aric Anderson
 *
 */
public class ActionPrinter {

    // tracks the total damage tanks have done for the turn to tell the player survivability information
    private int tankDamageTotal = 0;

    // Used to print if player input was a hit or miss
    public void printHitMiss(boolean hitMiss){

        System.out.println("Your cannon has been fired!\nYou listen for the sound of a hit.");

        if(hitMiss)
            System.out.println("******SMASH!*****\nYou hit a tank!");
        else
            System.out.println("*THUD*\nYou missed and hit the dirt!");

        System.out.println("Get to cover! The enemy is preparing to fire.");
    }

    // Used to print each individual tanks damage
    public void printTankDamage(int damage, int tankID){
        if (damage <= 0){
            System.out.println("Enemy tank " + tankID + " didn't fire and dealt 0 damage!");
        }
        else {
            System.out.println("Enemy tank " + tankID + " fired and did " + damage + " damage!");
        }
        // adds each individual tank's damage together to be used for displaying other information
        this.tankDamageTotal += damage;
    }

    // prints the total amount of damage every tank did to the player together
    public void printTotalTankDamage(){
        System.out.println("In total the tanks did " + this.tankDamageTotal + " points worth of damage");
    }

    // Used to print current health of the Fortress
    public void printFortressHealth(int currentHealth){

        //print the current health of the Fortress
        System.out.println("The Fortress has " + currentHealth + " health " + (currentHealth != 1 ? "points" : "point") + " remaining.");

        // show number of hits fortress can take after the first player turn
        if (currentHealth < 1500){
            //calculate how many more hits the fortress can take
            int hitsRemaining = (int) Math.ceil(currentHealth / tankDamageTotal);

            //print how many more hits the fortress can take
            if(hitsRemaining > 1) {
                System.out.println("At the current rate we'll only survive " + hitsRemaining + " more volleys!");
            }else if( hitsRemaining == 1)
                System.out.println("This is it! If we don't knock them out with this next shot the Fortress will fall!");

            // resets the total amount of tank damage back to 0 to prepare for the next turn
            this.tankDamageTotal = 0;
        }

    }

    // prints a message at the end of the game depending on if the player won or lost
    public void printWinLoss(boolean gameWon){
        if (gameWon){
            System.out.println("Congratulations! You destroyed every tank! You win!");
        }
        else {
            System.out.println("Your fortress is destroyed! You lose!");
        }
        System.out.println("Press enter to exit.");
    }
}
