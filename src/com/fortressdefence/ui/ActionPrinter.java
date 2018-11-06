package com.fortressdefence.ui;

public class ActionPrinter {

    private int tankDamageTotal;

    public ActionPrinter() {
        this.tankDamageTotal = 0;
    }

    public void printHitMiss(boolean hitMiss){

        System.out.println("Your cannon has been fired!\nYou listen for the sound of a hit.");

        if(hitMiss)
            System.out.println("******SMASH!*****\nYou hit a tank!");
        else
            System.out.println("*THUD*\nYou missed and hit the dirt!");

        System.out.println("Get to cover! The enemy is preparing to fire.");
    }

    public void printTankDamage(int damage, int tankID){

    }

    public void printFortressHealth(int currentHealth){



    }
}
