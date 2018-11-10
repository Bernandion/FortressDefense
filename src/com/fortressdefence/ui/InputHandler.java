package com.fortressdefence.ui;


import java.util.Scanner;

public class InputHandler {
    // private Scanner input;

    // int array for containing the input
    private int[] input = new int[2];

    public InputHandler() {
       input = new Scanner(System.in);
    }


    public void getInput(){

        System.out.print("Enter the board location you want to attack: ");
        String in = this.input.nextLine();
        char [] inCharArray = in.toCharArray();
        if((inCharArray[0] >= 'a' && inCharArray[0] <= 'j' || inCharArray[0] >= 'A' && inCharArray[0] <= 'J') && ((inCharArray[1] - '0') >= 1 && (inCharArray[1] - '0') <= 10 ) && !(inCharArray.length > 2)){
           System.out.println("Test Works");
        } else{
            System.out.println("Test Didn't Work");
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
