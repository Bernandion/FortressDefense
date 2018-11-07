package com.fortressdefence.game;

public class Tank {

    // tanks start with 1 health
    private int health = 1;

    private int damage;

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    /*
        ** DONT THINK THIS IS NEEDED **

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    */

    //Class Methods

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

    // decreases the tank's health by one of the player hits it
    public void decreaseHealth(){
        if (this.health > 0) this.health--;
        updateDamage();
    }

    // increases the tank's health by one during board creation
    public void increaseHealth(){
        if (this.health < 4) this.health++;
        updateDamage();
    }
}
