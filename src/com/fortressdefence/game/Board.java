package com.fortressdefence.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    // constant for defining the size of one side of the board
    private static final int ROW_SIZE = 10;

    // 2d array for containing the cells on the board
    private Cell cells[][] = new Cell[ROW_SIZE][ROW_SIZE];

    // arraylist for tracking all alive tanks still on the board
    private List<Tank> allTanks = new ArrayList<>();

    // constructor for initializing the cells on the board
    public Board(){
        for (int i=0; i<ROW_SIZE; i++){
            for (int j=0; j<ROW_SIZE; j++){
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    // initializing method for creating the tanks and setting up the board
    // randomly sets Tanks on the board and creates them
    public void setupBoard(){
        // arraylist for tracking cells that have been used for creating and extending a tank
        List<Cell> tankCells;
        // loops until 5 tanks are created on the board
        while (allTanks.size() < 5){
            // re-initialize the tankCells for new tank
            tankCells = new ArrayList<>();
            // get a random row and and column number for tank initial spot
            Random rand = new Random();
            int column = rand.nextInt(ROW_SIZE);
            int row = rand.nextInt(ROW_SIZE);
            // if the position already has a created tank on it, start again
            if (cells[row][column].hasTank()) continue;
            // add initial tank position to tank cell tracker
            tankCells.add(cells[row][column]);
            // create the tank at the spot and put a reference to the object into the allTanks arraylist
            Tank newTank = new Tank();
            cells[row][column].setTank(newTank);
            cells[row][column].setHasTank(true);
            allTanks.add(newTank);
            // randomly add onto the created tank until its of size 4 (health 4)
            while (newTank.getHealth() < 4){
                // randomly select one of the created parts of the tank (cells the tank is in) to build the next part off of
                int tankCell = rand.nextInt(tankCells.size());
                // randomly choose a cell adjacent to the selected part of the tank to build a new part
                // loops until the new part of the tank is created

                /**
                 * This can cause an infinite loop if a ship gets trapped in a box of tanks.
                 * Need to implement a limit on how many trys it gets to grow a tank,
                 * and make it restart the loop from where it chooses a tanks starting point
                 */
                while (true){
                    int nextCellRow, nextCellCol;
                    switch(rand.nextInt(4)){
                        // move to left cell
                        case 3:
                            nextCellRow = tankCells.get(tankCell).getRowNum();
                            nextCellCol = tankCells.get(tankCell).getColNum() - 1;
                            break;
                        // move to right cell
                        case 2:
                            nextCellRow = tankCells.get(tankCell).getRowNum();
                            nextCellCol = tankCells.get(tankCell).getColNum() + 1;
                            break;
                        // move to above cell
                        case 1:
                            nextCellRow = tankCells.get(tankCell).getRowNum() + 1;
                            nextCellCol = tankCells.get(tankCell).getColNum();
                            break;
                        // move to down cell
                        default:
                            nextCellRow = tankCells.get(tankCell).getRowNum() - 1;
                            nextCellCol = tankCells.get(tankCell).getColNum();
                            break;
                    }
                    // if adjacent index isnt out of range and a tank isnt already in the cell, extend the tank to the chosen cell
                    if (nextCellRow < ROW_SIZE && nextCellRow >= 0 && nextCellCol < ROW_SIZE && nextCellCol >= 0 && !cells[nextCellRow][nextCellCol].hasTank()){
                        // increment the tank's health and set the cell's booleans
                        newTank.increaseHealth();
                        cells[nextCellRow][nextCellCol].setTank(newTank);
                        cells[nextCellRow][nextCellCol].setHasTank(true);
                        // add the cell to the list of cells this tank occupies
                        tankCells.add(cells[nextCellRow][nextCellCol]);
                        break;
                    }
                }
            }
        }
    }

    /**
     *We should make input handler deal with parsing out the char into an int
     * and also confirming the input is within the bounds of the board.
     *
     * Select cell's parameters should just be two ints that have already been confirmed to be valid row and column locations
     * and just return the relative cell.
     */
    // selects a cell on the board from passed user input and returns a boolean for if the cell contains a tank or not
    // Note: if tank is hit, true gets returned to the GameMain which sends to printHitMiss in ActionPrinter
    // handles tank damage if the cell does contain a tank
    public boolean selectCell(char row, int column){
        // convert the character to an integer
        // * NOTE: MAY NOT WORK, QUICKLY FOUND CODE ONLINE *
        int rowIndex = (int)row % 32;
        // if happens to be outside range, simply return false
        if ((rowIndex > ROW_SIZE || rowIndex < 1)||(column > ROW_SIZE || column < 1)) return  false;
        Cell curCell = cells[rowIndex-1][column-1];
        boolean containsTank = curCell.hasTank();
        // if has tank that hasnt been hit yet, handle damage to tank
        if (containsTank && !curCell.isHit()){
            // decreases the health of the tank at this cell
            curCell.getTank().decreaseHealth();
            // set the cell to hit
            curCell.setIsHit(true);
        }
        return containsTank;

    }

    // returns true or false for if the there are any tanks still alive
    // Note: used for controlling when to stop the game in GameMain
    public boolean tanksAlive(){
        // returns true once a tank is found that has health
        for (Tank tank : allTanks){
            if (tank.getHealth() > 0) return true;
        }
        return false;
    }

    // accessor for the cells on the board
    // Note: used in GameBoardPrinter printBoard(Board) to iterate through to show board
    public Cell[][] getCells() { return this.cells; }

    // returns all the tanks for use in GameMain
    // Note: used in enemyTurn()
    public List<Tank> getAllTanks() { return this.allTanks; }

}