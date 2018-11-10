package com.fortressdefence.ui;


import java.util.Scanner;

public class InputHandler {
    // private Scanner input;

    // int array for containing the input
    private int[] input = new int[2];

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

    // DIFFERENT GET INPUT
    public boolean getInput() {
        System.out.print("Enter the board location you want to attack as a letter and number: ");
        Scanner scan = new Scanner(System.in);
        String input = "";
        if (scan.hasNext()) input = scan.nextLine();
        // removes any spaces in input
        input.replaceAll("\\s+", "");
        // returns false if too much input entered
        if (input.length() > 3) return false;
        // changes to character array
        char[] charinput = input.toCharArray();
        // returns false if character input not in range
        if (!(charinput[0] >= 'a' && charinput[0] <= 'j' || charinput[0] >= 'A' && charinput[0] <= 'J')) return false;
        // gets the alphabetical integer position of the character
        int intcharinput = (int)Character.toLowerCase(charinput[0]) - 96;
        // gets substring of part of input containing the number
        int enteredint = Integer.parseInt(input.substring(1));
        // returns false if the number entered is outside range
        if (enteredint < 1 || enteredint > 10) return false;
        // input good if at this point
        this.input[0] = intcharinput;
        this.input[1] = enteredint;
        return true;
    }

    // returns the input
    public int[] returnInput() { return this.input; }

}
