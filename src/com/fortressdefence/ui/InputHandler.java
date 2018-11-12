package com.fortressdefence.ui;


import java.util.Scanner;

/**
 * Handles input from the player for the game and returns input to be used in controlling the game.
 * Ensures only certain input is taken from the player.
 *
 * @author Brandon Verigin
 * @author Aric Anderson
 *
 */
public class InputHandler {

    private Scanner scan;

    // int array for containing the input to be returned to GameMain
    private int[] input;

    // constructor to initialize the Scanner with the System input stream
    public InputHandler() {
        scan = new Scanner(System.in);
    }

    // gets user input and returns a boolean for if the input was acceptable or not
    // returns true only if input consists of a letter followed by at most 2 numbers
    public boolean getGameInput(){

        // contains user input for the row and column
        char Row;
        int Col;

        // get input and put it in string
        String in = this.scan.nextLine();

        // get the first char from the string and parse int from rest of the characters
        try {
             // removes any spaces in input
             in.replaceAll("\\s+", "");
             Row = in.toLowerCase().charAt(0);
             Col = Integer.parseInt(in.substring(1));
        } catch (Exception e) { // if it fails to parse an int it throw an exception and sets Row and Col out of bounds
            Row = 'z';
            Col = 99;
        }

        // test if input is within bounds of the board
        if ((Row >= 'a' && Row <= 'j')  && (Col >= 1 && Col <= 10)) {
           // convert the Row into an int relative to its position in the alphabet
           // put the two integers into an int array and set the input to be returned as the int array
           int[] a = { (int)Row - 'a' + 1, Col};
           this.input = a;
           // return true indicating acceptable input
           return true;
        } else {
            System.out.println("Selection invalid. Input must be <letter><number> within the bounds of the board\nEXAMPLE: b5");
            // return false indicating bad input
            return false;
        }

    }

    // returns true when enter key is pressed
    public boolean getKeyPress(){
        this.scan.nextLine();
        return true;
    }

    // returns the user input to be used in controlling game
    public int[] returnInput() { return this.input; }

}
