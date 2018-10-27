package com.company;

public class Cell {

    private boolean isHit;
    private boolean hasTank;
    private Tank tank;

    public Cell( ) {
        this.isHit = false;
        this.hasTank = false;
        this.tank = null;
    }

    public boolean isHit() {
        return isHit;
    }

    public boolean HasTank() {
        return hasTank;
    }

    public void setHasTank(boolean hasTank) {
        this.hasTank = hasTank;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
