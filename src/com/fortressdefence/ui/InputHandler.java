package com.fortressdefence.ui;


import java.util.Scanner;

public class InputHandler {
    private Scanner input;

    public InputHandler() {
       input = new Scanner(System.in);
    }


    public int[] getInput(){

        System.out.print("Enter the board location you want to attack: ");
        char Row;
        int Col;
        // get input and put it in string
        while(true) {
            String in = this.input.nextLine();

            //turn string first char and parse int from last chars
            try {
                 Row = in.charAt(0);
                 Col = Integer.parseInt(in.substring(1));
            } catch (Exception e) { //if it fails to parse an int it throw an exception and sets Row and Col out of bounds
                Row = 'z';
                Col = 99;
            }

            // test if input is within bounds of the board
            if ((Row >= 'a' && Row <= 'j' || Row >= 'A' && Row <= 'J') && (Col >= 1 && Col <= 10)) {
                //, and return
               int[] a = { Row - 'a' + 1, Col};//convert the Row into an int relative to its position in the alphabet
               return a;
            } else {
                System.out.println("Selection invalid. Input must be <letter><number> within the bounds of the board\nEXAMPLE: b5");
            }
        }

    }

}
