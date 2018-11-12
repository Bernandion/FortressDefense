package com.fortressdefence.ui;

import com.fortressdefence.game.Board;
import com.fortressdefence.game.Cell;

/**
 * Takes a board object and prints the associated information from the board in a easy to view grid.
 * Shows locations of hits and and tanks.
 *
 * @author Brandon Verigin
 * @author Aric Anderson
 *
 */
public class GameBoardPrinter {


    // prints the board as normally seen throughout the game, with fog blocking vision of areas not hit
    public void printBoard(Board board){

        //get all the cells of the board to check them while printing
        Cell cells[][] = board.getCells();
        char colChar = 'A';

        //print out top row of the board
        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        // iterates through the 2d array of cells on the board to print their row and column info
        for(int row = 0; row < 10; row++){

            System.out.print(colChar + " ");

            for(int col = 0; col<10;col++){

                // prints an X representing a cell with a tank that has been hit and a . for a cell without a tank that has been hit
                // ~ is printed for cells not yet seen
                if(cells[row][col].hasTank() && cells[row][col].isHit())
                    System.out.print("X ");
                else  if(cells[row][col].isHit())
                    System.out.print(". ");
                else
                    System.out.print("~ ");
            }
            System.out.print("\n");
            colChar++;
        }

        System.out.print("Enter the board location you want to attack: ");
    }

    // prints the board seen at the end of the game if the player lost, showing places the tanks resided that weren't hit
    public void printBoardWithoutFog(Board board){
        //get all the cells of the board to check them while printing
        Cell cells[][] = board.getCells();
        char colChar = 'A';

        //print out top row of the board
        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        // iterates through the 2d array of cells on the board to print their row and column info
        for(int row = 0; row < 10; row++){

            System.out.print(colChar + " ");

            for(int col = 0; col<10;col++){

                // prints an X representing a cell with a tank that has been hit and a . for a cell without a tank that has been hit
                // prints a T for cells that have a tank but the player never chose. Fog replaced with - symbol
                if(cells[row][col].hasTank() && cells[row][col].isHit())
                    System.out.print("X ");
                else if(cells[row][col].isHit())
                    System.out.print(". ");
                else if(cells[row][col].hasTank())
                    System.out.print("T ");
                else
                    System.out.print("- ");
            }
            System.out.print("\n");
            colChar++;
        }
    }

}
