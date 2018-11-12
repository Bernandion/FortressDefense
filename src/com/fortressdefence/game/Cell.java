package com.fortressdefence.game;

/**
 * Represents a single square in the play area. Tracks state information for if it contains a tank or
 * if it's been hit.
 *
 * @author Brandon Verigin
 * @author Aric Anderson
 *
 */
public class Cell {

    private boolean isHit;
    private boolean hasTank;
    // tank reference kept as null unless a tank is created in the cell
    private Tank tank;
    // column and row cell belongs to
    private int colNum, rowNum;

    // initializes the booleans and sets the row and column this cell resides in
    public Cell(int rowNum, int colNum) {
        this.isHit = false;
        this.hasTank = false;
        this.tank = null;
        this.colNum = colNum;
        this.rowNum = rowNum;
    }

    // accessors
    public boolean isHit() { return isHit; }

    public boolean hasTank() {
        return hasTank;
    }

    public Tank getTank() {
        return tank;
    }

    public int getRowNum() {return this.rowNum;}

    public int getColNum() {return this.colNum;}

    // mutators

    public void setHasTank(boolean hasTank) {
        this.hasTank = hasTank;
    }

    public void setIsHit(boolean isHit) { this.isHit = isHit; }

    public void setTank(Tank tank) {
        this.tank = tank;
    }


}
