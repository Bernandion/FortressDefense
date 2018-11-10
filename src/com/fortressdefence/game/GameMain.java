package com.fortressdefence.game;

import com.fortressdefence.ui.ActionPrinter;
import com.fortressdefence.ui.GameBoardPrinter;
import com.fortressdefence.ui.InputHandler;

import java.util.List;

public class GameMain {

    // starting health for the player
    private int fortress = 1500;

    private Board gameBoard = new Board();

    private GameBoardPrinter boardPrinter = new GameBoardPrinter();

    private ActionPrinter actionPrinter = new ActionPrinter();

    private InputHandler inputHandler = new InputHandler();

    private void enemyTurn(){
        // sends enemy damage to the actionprinter and deals the damage to the fortress health for each tank
        List<Tank> enemyTanks = gameBoard.getAllTanks();
        for(int i=0; i<enemyTanks.size(); i++){
            // sends the damage for each tank to the printer
            actionPrinter.printTankDamage(enemyTanks.get(i).getDamage(), i+1);
            // deals the damage for each tank to the health
            fortress -= enemyTanks.get(i).getDamage();
        }
    }

    private void playerTurn(){
        // loops until valid input is received
        while (!inputHandler.getInput());
        int[] input = inputHandler.returnInput();
        // tries to hit the selected cell
        boolean hitMiss = gameBoard.selectCell(input[0], input[1]);
        // prints if the choice was a hit or not
        actionPrinter.printHitMiss(hitMiss);

    }

    private void run(){
        // initial board setup
        gameBoard.setupBoard();
        while(true){
            // if player loses (fortress health reduced to 0) shows complete game board
            if (fortress <= 0){
                // ACTIONPRINTER OR SOMETHING PRINTS MESSAGE SAYING GAME LOST
                // CODE FOR PRINTING THE ENTIRE BOARD WITHOUT FOG FROM GAMEBOARDPRINTER HERE

                // breaks out of the game once a key is pressed
                if (/* ANYTHING ENTERED AS INPUT USING INPUTHANDLER*/) break;
            }
            // if no tanks are alive, player wins
            else if (!gameBoard.tanksAlive()){
                // ACTIONPRINTER OR SOMETHING PRINTS MESSAGE SAYING GAME WON

                // breaks out of the game once a key is pressed
                if (/* ANYTHING ENTERED AS INPUT USING INPUTHANDLER*/) break;
            }
            // run game normally
            else {
                // SHOW THE GAME BOARD AND FORTRESS HEALTH
                boardPrinter.printBoard(gameBoard);
                actionPrinter.printFortressHealth(fortress);
                // do actions for the players turn
                playerTurn();
                // do actions for enemy turn
                enemyTurn();

            }
        }
    }

    public static void main(String[] args) {

        // running the game
        GameMain game = new GameMain();
        game.run();
    }
}
