package com.fortressdefence.ui;

import com.fortressdefence.game.Board;
import com.fortressdefence.game.Cell;

public class GameBoardPrinter {


    public void printBoard(Board board){

        //get all the cells of the board to check them while printing
        Cell cells[][] = board.getCells();
        char colChar = 'A';

        //print out top row of the board
        System.out.println("  1 2 3 4 5 6 7 8 9 10");

        for(int row = 0; row < 10; row++){

            System.out.print(colChar + " ");

            for(int col = 0; col<10;col++){

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
    }
}
