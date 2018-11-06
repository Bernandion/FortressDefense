package com.fortressdefence.game;

public class Tank {
    private int health;
    private int damage;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


    //Class Methods

    public void updateDamage(){
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
            case 0:
                this.damage = 0;
                break;
        }
    }

    public void decreaseHealth(int damage){
        this.health -= damage;
    }

    public void increaseHealth(int damage){
        this.health += damage;
    }
}
