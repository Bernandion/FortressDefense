package com.fortressdefence.ui;

public class ActionPrinter {

    private int tankDamageTotal = 0;

    /**
     * Used to print if player input was a hit or miss
     * @param hitMiss
     */
    public void printHitMiss(boolean hitMiss){

        System.out.println("Your cannon has been fired!\nYou listen for the sound of a hit.");

        if(hitMiss)
            System.out.println("******SMASH!*****\nYou hit a tank!");
        else
            System.out.println("*THUD*\nYou missed and hit the dirt!");

        System.out.println("Get to cover! The enemy is preparing to fire.");
    }


    /**
     * Used to print each Tanks damage individually
     * @param damage tank damage
     * @param tankID tank ID
     */
    public void printTankDamage(int damage, int tankID){
        if (damage <= 0){
            System.out.println("Enemy tank " + tankID + " didn't fire and dealt 0 damage!");
        }
        else {
            System.out.println("Enemy tank " + tankID + " fired and did " + damage + " damage!");
        }
        this.tankDamageTotal += damage;
    }

    public void printTotalTankDamage(){
        //print how much damage all the tanks did
        System.out.println("In total the tanks did " + this.tankDamageTotal + " points worth of damage");
    }


    /**
     * Used to print current health of the Fortress
     * @param currentHealth Fortress Health
     */
    public void printFortressHealth(int currentHealth){


        //print the current health of the Fortress
        System.out.println("The Fortress has " + currentHealth + " health " + (currentHealth != 1 ? "points" : "point") + " remaining.");
        /**
         * Replace code above with code below if ternary operator does not work
         */
            /*if(currentHealth > 1)
                System.out.println("The Fortress has " + currentHealth + " health points remaining.");
            else
                System.out.println("The Fortress has " + currentHealth + " health points remaining.");*/

        // show number of hits fortress can take after the first player turn
        if (currentHealth < 1500){
            //calculate how many more hits the fortress can take
            int hitsRemaining = (int) Math.ceil(currentHealth / tankDamageTotal);

            //print how many more hits the fortress can take
            if(hitsRemaining > 1) {
                System.out.println("At the current rate we'll only survive " + hitsRemaining + " more volleys!");
            }else if( hitsRemaining == 1)
                System.out.println("This is it! If we don't knock them out with this next shot the Fortress will fall!");

            this.tankDamageTotal = 0;
        }

    }

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
