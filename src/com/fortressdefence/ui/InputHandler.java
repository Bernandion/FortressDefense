package com.fortressdefence.ui;


import java.util.Scanner;

public class InputHandler {

    private Scanner scan;

    // int array for containing the input
    private int[] input;

    public InputHandler() {
        scan = new Scanner(System.in);
    }


    public boolean getGameInput(){

        char Row;
        int Col;

        // get input and put it in string
        String in = this.scan.nextLine();

        //turn string first char and parse int from last chars
        try {
             // removes any spaces in input
             in.replaceAll("\\s+", "");
             Row = in.charAt(0);
             Col = Integer.parseInt(in.substring(1));
        } catch (Exception e) { //if it fails to parse an int it throw an exception and sets Row and Col out of bounds
            Row = 'z';
            Col = 99;
        }

        // test if input is within bounds of the board
        if ((Row >= 'a' && Row <= 'j' || Row >= 'A' && Row <= 'J') && (Col >= 1 && Col <= 10)) {
            //, and return
            // NOTE: IF THAT DOESNT WORK FOR CONVERTING THE CHAR INTO INT TRY USING: (int)Character.toLowerCase(Row) - 96
           int[] a = { (int)Row - 'a' + 1, Col}; //convert the Row into an int relative to its position in the alphabet
           this.input = a;
           return true;
        } else {
            System.out.println("Selection invalid. Input must be <letter><number> within the bounds of the board\nEXAMPLE: b5");
            return false;
        }

    }

    // returns true when key pressed
    public boolean getKeyPress(){
        this.scan.nextLine();
        return true;
    }

    // returns the input
    public int[] returnInput() { return this.input; }

}
