package com.company;

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
                damage = 20;
                break;
            case 3:
                damage = 5;
                break;
            case 2:
                damage = 2;
                break;
            case 1:
                damage = 1;
                break;
            case 0:
                damage = 0;
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
