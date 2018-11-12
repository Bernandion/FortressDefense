package com.fortressdefence.game;

import com.fortressdefence.ui.ActionPrinter;
import com.fortressdefence.ui.GameBoardPrinter;
import com.fortressdefence.ui.InputHandler;

import java.util.List;

/**
 * Main class for running the game and controlling what happens at each point in the game.
 *
 * @author Brandon Verigin
 * @author Aric Anderson
 *
 */
public class GameMain {

    // starting health for the player
    private int fortress = 1500;

    private Board gameBoard = new Board();

    private GameBoardPrinter boardPrinter = new GameBoardPrinter();

    private ActionPrinter actionPrinter = new ActionPrinter();

    private InputHandler inputHandler = new InputHandler();

    // handles the actions to be taken on the enemy's turn in the game
    private void enemyTurn(){
        // sends enemy damage to the actionprinter and deals the damage to the fortress health for each tank
        List<Tank> enemyTanks = gameBoard.getAllTanks();
        for(int i=0; i<enemyTanks.size(); i++){
            // sends the damage for each tank to the printer
            actionPrinter.printTankDamage(enemyTanks.get(i).getDamage(), i+1);
            // deals the damage for each tank to the health
            fortress -= enemyTanks.get(i).getDamage();
        }
        // show the total amount of damage the tanks did to the player for this turn
        actionPrinter.printTotalTankDamage();
    }

    // handles the actions to be taken on the player's turn in the game
    private void playerTurn(){
        // loops until valid input is received
        while (!inputHandler.getGameInput());
        int[] input = inputHandler.returnInput();
        // tries to hit the selected cell
        boolean hitMiss = gameBoard.selectCell(input[0], input[1]);
        // prints if the choice was a hit or not
        actionPrinter.printHitMiss(hitMiss);
    }

    // main method for running the entire game and exiting the game in certain conditions
    private void run(){
        // initial board setup
        gameBoard.setupBoard();
        while(true){
            // if player loses (fortress health reduced to 0) shows complete game board
            if (fortress <= 0){
                // print the board without fog on loss
                boardPrinter.printBoardWithoutFog(gameBoard);
                // print message saying game lost
                actionPrinter.printWinLoss(false);
                // breaks out of the game once a key is pressed
                if (inputHandler.getKeyPress()) break;
            }
            // if no tanks are alive, player wins
            else if (!gameBoard.tanksAlive()){
                // print message saying game won
                actionPrinter.printWinLoss(true);
                // breaks out of the game once a key is pressed
                if (inputHandler.getKeyPress()) break;
            }
            // run game normally
            else {
                // show the gameboard and fortress health information
                actionPrinter.printFortressHealth(fortress);
                boardPrinter.printBoard(gameBoard);
                // do actions for the players turn
                playerTurn();
                // do actions for enemy turn
                enemyTurn();

            }
        }
    }

    public static void main(String[] args) {

        // playing the game
        GameMain game = new GameMain();
        game.run();
    }
}
