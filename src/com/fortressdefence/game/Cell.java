package com.fortressdefence.game;

public class Cell {

    private boolean isHit;
    private boolean hasTank;
    private Tank tank;
    // column and row cell belongs to
    private int colNum, rowNum;

    public Cell(int rowNum, int colNum) {
        this.isHit = false;
        this.hasTank = false;
        this.tank = null;
        this.colNum = colNum;
        this.rowNum = rowNum;
    }

    public boolean isHit() { return isHit; }

    public boolean hasTank() {
        return hasTank;
    }

    public void setHasTank(boolean hasTank) {
        this.hasTank = hasTank;
    }

    public void setIsHit(boolean isHit) { this.isHit = isHit; }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public int getRowNum() {return this.rowNum;}

    public int getColNum() {return this.colNum;}
}
