package com.fortressdefence.game;

/**
 * Represents an enemy tank that can fire shots and has a certain amount of health based on it's size.
 *
 * @author Brandon Verigin
 * @author Aric Anderson
 *
 */
public class Tank {

    // tanks start with 1 health
    private int health = 1;

    // damage dynamically changed throughout game based on health
    private int damage;

    // private method for updating the tanks damage when its health increases or decreases
    private void updateDamage(){
        switch (this.health){
            case 4:
                this.damage = 20;
                break;
            case 3:
                this.damage = 5;
                break;
            case 2:
                this.damage = 2;
                break;
            case 1:
                this.damage = 1;
                break;
            default:
                this.damage = 0;
                break;
        }
    }

    // decreases the tank's health by one if the player hits it
    public void decreaseHealth(){
        // health cant be lower than 0
        if (this.health > 0) this.health--;
        updateDamage();
    }

    // increases the tank's health by one during board creation
    public void increaseHealth(){
        // health cant be higher than 4
        if (this.health < 4) this.health++;
        updateDamage();
    }

    // accessors

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

}
